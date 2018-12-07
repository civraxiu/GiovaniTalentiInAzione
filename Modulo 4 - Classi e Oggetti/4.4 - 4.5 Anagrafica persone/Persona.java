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

public class Persona {

	private String nome;
	private String cognome;
	private DataDiNascita dataDiNascita;
	
	/*
	 * Inner static class
	 */
	private static class DataDiNascita {
		int giorno;
		int mese;
		int anno;	
				
		public String toString() {
			return giorno+"/"+mese+"/"+anno;
		}
	}	
	
	public Persona(
			String nome,
			String cognome,
			int giorno,
			int mese,
			int anno) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = new DataDiNascita();
		this.dataDiNascita.giorno = giorno;
		this.dataDiNascita.mese = mese;
		this.dataDiNascita.anno = anno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public int getGiorno() {
		return dataDiNascita.giorno;
	}

	public void setGiorno(int giorno) {
		this.dataDiNascita.giorno = giorno;
	}

	public int getMese() {
		return this.dataDiNascita.mese;
	}

	public void setMese(int mese) {
		this.dataDiNascita.mese = mese;
	}

	public int getAnno() {
		return this.dataDiNascita.anno;
	}

	public void setAnno(int anno) {
		this.dataDiNascita.anno = anno;
	}
	
	public String toString() {
		String output = "";
		output += "Nome: " + nome + "\n";
		output += "Cognome: " + cognome + "\n";
		output += "Data di nascita: "+dataDiNascita+"\n";
		return output;
	}
}











