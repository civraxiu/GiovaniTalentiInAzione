/*
 * Copyright 2018 - Nicola Atzei (atzeinicola@gmail.com)
 * Copyright 2018 - Livio Pompianu (pompianu.livio@gmail.com)
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

package it.ytia.anagrafica.logica.persone;

import java.util.ArrayList;


public class Docente extends Impiegato{
	
	private ArrayList<String> esami;
	
	public Docente(
			String nome,
			String cognome,
			int giorno,
			int mese,
			int anno,
			int stipendio,
			ArrayList<String> esami
	) {
		super(nome, cognome, giorno, mese, anno, stipendio);
		this.esami = esami;
	}
	
	@Override
	public String toString() {
		String output = super.toString();
		output += "Esami: " + esami + "\n";
		return output;
	}
	
	public ArrayList<String> getEsami(){
		return this.esami;
	}
}
