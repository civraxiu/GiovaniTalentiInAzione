package it.ytia.anagrafica.logica.persone;


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
	
	@Override
	public String toString() {
		String output = super.toString();
		output += "Stipendio: "+stipendio+"\n";
		return output;
	}
}








