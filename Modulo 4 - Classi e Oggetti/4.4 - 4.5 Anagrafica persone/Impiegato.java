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

public class Impiegato extends Persona {

	private int stipendio;
	
	public Impiegato(
			String nome,
			String cognome,
			int giorno,
			int mese,
			int anno,
			int stipendio
			) {
		super(nome,cognome,giorno,mese,anno);
		this.stipendio = stipendio;
	}

	public Impiegato(Persona p, int stipendio) {
		this(
				p.getNome(),
				p.getCognome(),
				p.getGiorno(),
				p.getMese(),
				p.getAnno(),
				stipendio);
	}

	public int getStipendio() {
		return stipendio;
	}

	public void setStipendio(int stipendio) {
		this.stipendio = stipendio;
	}
	
	public String toString() {
		String output = super.toString();
		output += "Stipendio: "+stipendio+"\n";
		return output;
	}
}








