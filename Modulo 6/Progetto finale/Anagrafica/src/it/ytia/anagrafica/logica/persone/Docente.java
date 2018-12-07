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
