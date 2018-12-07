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

import java.util.ArrayList;
import java.util.List;

public class Audiola implements LettoreMultimediale, Playlist {

	private static final byte PLAYING = 0;
	private static final byte STOPPED = 1;
	private static final byte PAUSED = 2;
	private static final int VOLUME_PRED = MAX_VOLUME / 2;
	
	/*
	 * LettoreMultimediale
	 */
	private byte stato = STOPPED;
	private int volume = VOLUME_PRED;
	private int volumeBeforeMute;
	private boolean isMute = false;
	
	/*
	 * Playlist
	 */
	private List<String> tracce = new ArrayList<String>();
	private int tracciaCorrente = 0;
	private boolean isRepeatOn = false;

	public void play() {
		stato = PLAYING;
	}

	public void stop() {
		stato = STOPPED;		
	}

	public void pause() {
		if (stato == PLAYING)
			stato = PAUSED;
	}

	public boolean isPlaying() {
		return stato == PLAYING;
	}

	public boolean isStopped() {
		return stato == STOPPED;
	}

	public boolean isPaused() {
		return stato == PAUSED;
	}

	public int volumeUp() {
		return volumeUp(1);
	}

	public int volumeUp(int n) {
		unmute();
		if (volume + n <= MAX_VOLUME)
			volume += n;
		else 
			volume = MAX_VOLUME;
		return volume;
	}

	public int volumeDown() {
		return volumeDown(1);
	}

	public int volumeDown(int n) {
		unmute();
		if (volume - n >= 0)
			volume -= n;
		else 
			volume = 0;
		return volume;
	}

	public int volume() {
		return volume;
	}

	public void mute() {
		if (!isMute) {
			volumeBeforeMute = volume;
			volume = 0;
			isMute = true;
		}
	}

	public void unmute() {
		if (isMute) {
			volume = volumeBeforeMute;
			isMute = false;
		}
	}
	
	public String toString() {
		String stato = 
			this.stato==PLAYING? "PLAYING": 
			(this.stato==PAUSED?"PAUSED": "STOPPED");
		String output = "";
		output += "Stato: "+ stato+"\n";
		output += "Volume: "+ volume+"\n";
		output += "Mute: "+ (isMute? "on":"off")+"\n";
		return output;
	}

	public void add(String traccia) {
		tracce.add(traccia);
	}

	public String tracciaCorrente() {
		if (tracce.isEmpty()) {
			return "Nessuna traccia";
		}
		return tracce.get(tracciaCorrente);
	}

	public void next() {
		if (tracciaCorrente + 1 < tracce.size()) {
			tracciaCorrente++;
		}
		else {
			// tracciaCorrente == size()-1
			if (isRepeatOn)
				tracciaCorrente=0;
		}
	}

	public void prev() {
		if (tracciaCorrente > 0) {
			tracciaCorrente--;
		}
		else {
			// tracciaCorrente == 0
			if(isRepeatOn)
				tracciaCorrente = tracce.size() - 1;
		}
	}

	public boolean repeat() {
		return isRepeatOn;
	}

	public void setRepeat(boolean value) {
		isRepeatOn = value;
	}

}
