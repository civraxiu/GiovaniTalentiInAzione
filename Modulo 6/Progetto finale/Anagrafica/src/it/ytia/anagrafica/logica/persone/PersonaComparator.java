package it.ytia.anagrafica.logica.persone;

import java.util.Comparator;

/**
 * Permette di ordinare due oggetti di tipo Persona con un criterio
 * personalizzato e indipendente da quello sviluppato nel Comparable
 * della classe Persona. Il Comparator è ideale quando si vogliono
 * ordinare oggetti di una classe sui non si ha la possibilità
 * di modificare il codice (e, ad esempio, implementare Comparable).
 * 
 * @author Livio
 *
 */
public class PersonaComparator implements Comparator<Persona>{

	@Override
	/**
	 * Rende un numero positivo se p1 è maggiore di p2, 0 se sono omonimi,
	 * un numero negativo se p1 è minore di p2.
	 * 
	 * (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Persona p1, Persona p2){
		
		// Ordine alfabetico, prima per cognome e poi per nome
		
		if( p1.getCognome().compareTo(p2.getCognome()) < 0) return -2;
		if( p1.getCognome().compareTo(p2.getCognome()) == 0) {
			
			if( p1.getNome().compareTo(p2.getNome()) < 0) return -2;
			if( p1.getNome().compareTo(p2.getNome()) == 0) return 0;

		}
		
		return 2;
	}
}
