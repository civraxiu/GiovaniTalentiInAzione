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
 * Interfaccia per una semplice playlist di tracce audio
 */
public interface Playlist {
	
	public static final String NO_TRACK = "Nessuna traccia";
	
	/**
	 * Aggiunge una traccia alla playlist.
	 * La nuova traccia verrà inserita in fondo
	 * alla playlist.
	 * 
	 * @param traccia la nuova traccia da inserire
	 */
	public void add(String traccia);
	
	/**
	 * Restituisce la traccia corrente.
	 * Se non è presente nessuna traccia, restituisce
	 * {@link Playlist#NO_TRACK}.
	 * 
	 * @return la traccia corrente
	 */
	public String tracciaCorrente();
	
	/**
	 * Vai alla traccia successiva.
	 * Se {@link Playlist#repeat()}<code> == true</code>
	 * e siamo nell'ultima traccia, riparte da 0.
	 * Se {@link Playlist#repeat()}<code> == false</code>
	 * e siamo nell'ultima traccia, resta fermo.
	 */
	public void next();

	/**
	 * Vai alla traccia precedente.
	 * Se {@link Playlist#repeat()}<code> == true</code>
	 * e siamo nell'ultima traccia, riparte dall'ultima traccia.
	 * Se {@link Playlist#repeat()}<code> == false</code>
	 * e siamo nell'ultima traccia, resta fermo.
	 */
	public void prev();
	
	/**
	 * Verifica se la modalità ciclica è attiva.
	 * @return true se è attiva, false altrimenti.
	 */
	public boolean repeat();
	
	/**
	 * Cambia la modalità ciclica.
	 * @param value true abilità la modalità ciclica,
	 * false la disabilita.
	 */
	public void setRepeat(boolean value);
}
