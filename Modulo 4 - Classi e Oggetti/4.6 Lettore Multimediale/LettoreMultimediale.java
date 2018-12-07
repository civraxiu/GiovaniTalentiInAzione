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

/**
 * Interfaccia per un semplice lettore multimediale
 */
public interface LettoreMultimediale {

    public static final int MAX_VOLUME = 100;
    
    /**
     * Avvia il lettore.
     */
    public void play();
    
    /**
     * Ferma il lettore
     */
    public void stop();

    /**
     * Mette in pausa il lettore
     */
    public void pause();
    
    /**
     * Controlla se il lettore è in esecuzione.
     * 
     * @return true se è in esecuzione, false altrimenti.
     */
    public boolean isPlaying();

    /**
     * Controlla se il lettore è fermo.
     * 
     * @return true se è fermo, false altrimenti.
     */
    public boolean isStopped();
    
    /**
     * Controlla se il lettore è in pausa.
     * 
     * @return true se è in pausa, false altrimenti.
     */
    public boolean isPaused();
    
    /**
     * Aumenta il volume del lettore di una unità.
     * È equivalente a eseguire volumeUp(1).
     * Il volume non può superare {@link LettoreMultimediale#MAX_VOLUME}.
     *
     * @return il nuovo valore del volume
     */
    public int volumeUp();

    /**
     * Aumenta il volume del lettore di n unità.
     * È equivalente a eseguire volumeUp(1).
     * Il volume non può superare {@link LettoreMultimediale#MAX_VOLUME}.
     * 
     * @param n incremento del volume
     * @return il nuovo valore del volume
     */
    public int volumeUp(int n);

    /**
     * Diminuisce il volume del lettore di una unità.
     * È equivalente a eseguire volumeUp(1).
     * Il volume non può diventare negativo.
     *
     * @return il nuovo valore del volume
     */
    public int volumeDown();

    /**
     * Diminuisce il volume del lettore di n unità.
     * È equivalente a eseguire volumeDown(1).
     * Il volume non può diventare negativo.
     * 
     * @param n incremento del volume
     * @return il nuovo valore del volume
     */
    public int volumeDown(int n);

    /**
     * Restituisce il valore del volume.
     * Il valore sarà compreso tra 0 e {@link LettoreMultimediale#MAX_VOLUME}.
     * 
     * @return il valore del volume
     */
    public int volume();
    
    /**
     * Il volume diventa 0.
     * Se già muto, non fa nulla.
     */
    public void mute();
    
    /**
     * Il volume prende il valore che aveva prima di diventare muto.
     * Se non è muto, lascia il volume invariato.
     */
    public void unmute();
    
    
}
