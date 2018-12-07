package it.ytia.anagrafica.logica.persone;

public class Persona implements Comparable<Persona>{

	private String nome;
	private String cognome;
	private DataDiNascita dataDiNascita;
	
	public Persona(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}

	public Persona(
			String nome,
			String cognome,
			int giorno,
			int mese,
			int anno) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = new DataDiNascita(giorno, mese, anno);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getGiorno(){
		return dataDiNascita.getGiorno();
	}
	
	public int getMese(){
		return dataDiNascita.getMese();
	}
	
	public int getAnno(){
		return dataDiNascita.getAnno();
	}
	
	
	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	@Override
	public String toString() {
		String output = "";
		output += "Nome: " + nome + "\n";
		output += "Cognome: " + cognome + "\n";
		output += "Data di nascita: "+dataDiNascita+"\n";
		return output;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((dataDiNascita == null) ? 0 : dataDiNascita.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
    
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Persona))
			return false;
		Persona other = (Persona) obj;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (dataDiNascita == null) {
			if (other.dataDiNascita != null)
				return false;
		} else if (!dataDiNascita.equals(other.dataDiNascita))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
    
	@Override
	public int compareTo(Persona other) {
		return this.dataDiNascita.compareTo(other.dataDiNascita);
	}

	
	
	
	
	
    
    private static class DataDiNascita implements Comparable<DataDiNascita>{
		int giorno;
    	int mese;
    	int anno;
    	
    	public DataDiNascita(int giorno, int mese, int anno) {
    		this.giorno = giorno;
    		this.mese = mese;
    		this.anno = anno;
    	}
    	
    	@Override
    	public String toString() {
    		return giorno + "/" + mese + "/" + anno;
    	}
    	
    	@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + anno;
			result = prime * result + giorno;
			result = prime * result + mese;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			DataDiNascita other = (DataDiNascita) obj;
			if (anno != other.anno)
				return false;
			if (giorno != other.giorno)
				return false;
			if (mese != other.mese)
				return false;
			return true;
		}
		
		@Override
		public int compareTo(DataDiNascita other) {
			
			if(this.anno > other.anno) return -1;
			if(this.anno == other.anno) {
				
				if(this.mese > other.mese) return -1;
				if(this.mese == other.mese) {
					
					if(this.giorno > other.giorno) return -1;
					if(this.giorno == other.giorno) return 0;
				}
			}
			
			return 1;
		}
		
    	public int getGiorno() {
			return giorno;
		}

		public void setGiorno(int giorno) {
			this.giorno = giorno;
		}

		public int getMese() {
			return mese;
		}

		public void setMese(int mese) {
			this.mese = mese;
		}

		public int getAnno() {
			return anno;
		}

		public void setAnno(int anno) {
			this.anno = anno;
		}
    }	
}















