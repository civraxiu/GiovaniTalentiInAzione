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

public class Anagrafica {
	
	private Persona[] persone;
	
	public Anagrafica(int numMaxDiPersone) {
		this.persone = new Persona[numMaxDiPersone];
		// [null, null, null, ...]
	}
	
	/**
	 * Aggiunge due o più persone all'anagrafica.
	 * Equivalenta a:
	 * <pre>
	 * int n = add(first)? 1 : 0;
	 * for (Persona p : persone) {
	 * 	 if (add(p))
	 * 	   n++;
	 * }
	 * return n;
	 * </pre>
	 * @param persone le persone da aggiungere
	 * @return il numero di persone aggiunte
	 */
	public int add(Persona first, Persona... persone) {
		int n = add(first)? 1 : 0;
		for (Persona p : persone) {
			if (add(p))
				n++;
		}
		return n;
	}
	
	/**
	 * Aggiunge una persona all'anagrafica, senza inserire
	 * duplicati.
	 * @param p la persona da aggiungere
	 * @return true se la persona viene aggiunta, false altrimenti
	 */
	public boolean add(Persona p) {
		for(int i = 0; i<persone.length; i++) {
			if (persone[i] == null) {
				persone[i] = p;
				return true;
			}
			else {
				if (p.getNome() == persone[i].getNome() &&
						p.getCognome() == persone[i].getCognome() &&
						p.getGiorno() == persone[i].getGiorno() &&
						p.getMese() == persone[i].getMese() &&
						p.getAnno() == persone[i].getAnno() ) {
					return false;
				}
			}
		}
		System.out.println("Errore: anagrafica piena!");
//		throw new Error("Errore: anagrafica piena!");
		return false;
	}
	
	/**
	 * Rimuove una persona se presente. Sposta tutto a sinistra.
	 * @param p la persona da rimuovere
	 * @return true se la persona viene rimossa, false altrimenti.
	 */
	public boolean remove(Persona p) {
		for(int i = 0; i<persone.length; i++) {
			if (persone[i] == null) {
				return false;
			}
			else {
				if (p.getNome() == persone[i].getNome() &&
						p.getCognome() == persone[i].getCognome() &&
						p.getGiorno() == persone[i].getGiorno() &&
						p.getMese() == persone[i].getMese() &&
						p.getAnno() == persone[i].getAnno() ) {
					persone[i] = null;	
					
					// sposta gli elementi a sinistra
					for (int j=i+1; j<persone.length; j++) {
						persone[j-1] = persone[j];	// sposta a sx
						persone[j] = null;			// metti a null
					}
					return true;
				}
			}
		}
		return false;
	}

	public String toString() {
		String output = "";
		for (Persona p : persone) {
			if (p != null) {
				output += p.toString() + "\n";
			}
		}
		return output;
	}
	
	public Persona[] filterByName(String nome) {
		
		int n = 0;
		for (int i=0; i<persone.length; i++) {
			if (	persone[i] != null && 
					persone[i].getNome().compareToIgnoreCase(nome) == 0)
				n++; // n = n + 1 // n += 1
		}
		
		Persona[] output = new Persona[n];
		
		for (int i=0, j=0; i<persone.length; i++) {
			if (	persone[i] != null && 
					persone[i].getNome().compareToIgnoreCase(nome) == 0) {
				output[j] = persone[i];
				j++;
			}
		}
		
		return output;
	}	
}
