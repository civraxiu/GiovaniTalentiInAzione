/*
 * Copyright 2018 - Nicola Atzei (atzeinicola@gmail.com)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 * 
 */
public class TestLettoreMultimediale {

    public static void main(String[] args) {
        
        LettoreMultimediale lettore = new Audiola();
        
        /*
         * Controlla lo stato
         */
        assert lettore.isStopped() : "Un lettore appena creato è stopped";
        assert !lettore.isPaused() : "Se è fermo non può essere in pausa";
        assert !lettore.isPlaying() : "Se è fermo non può essere in esecuzione";

        lettore.play();
        assert lettore.isPlaying() : "Abbiamo invocato play(), dovrebbe essere true";
        
        lettore.stop();
        assert lettore.isStopped() : "Abbiamo invocato stop(), dovrebbe essere true";

        lettore.pause();
        assert lettore.isPaused() == false : "Abbiamo invocato stop(), pausa non ha effetto";

        lettore.play();
        lettore.pause();
        assert lettore.isPaused(): "Abbiamo invocato pause(), dovrebbe essere true";
        
        /*
         * Volume iniziale
         */
        int volumeIniziale = lettore.volume();
        assert volumeIniziale == LettoreMultimediale.MAX_VOLUME / 2 : "Appena creato, il volume di default è al 50%";

        /*
         * Alziamo il volume
         */
        lettore.volumeUp();
        assert lettore.volume() == volumeIniziale + 1;

        lettore.volumeUp(2);
        assert lettore.volume() == volumeIniziale + 1 + 2;
        
        /*
         * Raggiungiamo il volume massimo
         */
        lettore.volumeUp(LettoreMultimediale.MAX_VOLUME);
        assert lettore.volume() == LettoreMultimediale.MAX_VOLUME;
        
        /*
         * Abbassiamo il volume, fino al minimo
         */
        assert lettore.volumeDown() == LettoreMultimediale.MAX_VOLUME - 1;
        assert lettore.volumeDown(3) == LettoreMultimediale.MAX_VOLUME - 1 - 3;
        assert lettore.volumeDown(LettoreMultimediale.MAX_VOLUME) == 0;

        /*
         * Mute
         */
        lettore.volumeUp(5);
        int volumeBeforeMute = lettore.volume();
        lettore.mute();
        
        assert lettore.volume() == 0;
        // volume = 0, volumeBeforeMute = 5
        lettore.mute();
        // volume = 0, volumeBeforeMute = 0
        lettore.mute();
        // volume = 0, volumeBeforeMute = 0
        lettore.mute();
        // volume = 0, volumeBeforeMute = 0
        
        assert lettore.volume() == 0;
    
        lettore.unmute();
        
        assert lettore.volume() == volumeBeforeMute: 
        "Volume: "+lettore.volume()+
        ". VolumeBeforeMute: "+volumeBeforeMute;
        
        /*
         * Mute and volumeUp
         */
        volumeBeforeMute = lettore.volume();
        lettore.mute();
        assert lettore.volume() == 0;
        assert lettore.volumeUp() == volumeBeforeMute + 1;
    
        /*
         * Playlist
         */
        Playlist playlist = new Audiola();
        assert playlist.tracciaCorrente() == "Nessuna traccia";
        assert playlist.repeat() == false: "Repeat è disabilitato appena l'oggetto viene creato";
    
        String traccia1 = "Galway GirlEd Sheeran • ÷ (Deluxe)";
        String traccia2 = "Scared to Be LonelyMartin GarrixDua Lipa";
        String traccia3 = "SlideCalvin HarrisFrank OceanMigos • Slide";
        
        playlist.add(traccia1);
        assert playlist.tracciaCorrente() == traccia1;
    
        playlist.add(traccia2);
        playlist.add(traccia3);
        assert playlist.tracciaCorrente() == traccia1;
    
        playlist.next();
        playlist.next();
        playlist.next();
        playlist.next();
        playlist.next();
        playlist.next();
        assert playlist.tracciaCorrente() == traccia3;
        
        playlist.setRepeat(true);
        assert playlist.repeat() == true;

        playlist.next();
        playlist.next();
        assert playlist.tracciaCorrente() == traccia2;

        playlist.setRepeat(false);
        playlist.prev();
        playlist.prev();
        playlist.prev();
        playlist.prev();
        assert playlist.tracciaCorrente() == traccia1;
        
        playlist.setRepeat(true);
        playlist.prev();
        assert playlist.tracciaCorrente() == traccia3; 
        
        System.out.println("FINE TEST");
    }
    
}
