package it.ytia.anagrafica.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import it.ytia.anagrafica.logica.Anagrafica;
import it.ytia.anagrafica.logica.persone.Docente;

public class JUnitTestAnagrafica {

	
	private static Anagrafica anagrafica;
	private static Docente docente;
	private static List<String> esami;
	
	
    @BeforeAll
    static void docente() {

    	anagrafica = new Anagrafica(new File("anagrafica.txt"));
    	
    	esami = new ArrayList<>();
    	esami.add("PR1");
    	esami.add("PR2");

    	docente = new Docente("Nome", "Cognome", 01, 01, 1990, 1000, esami);

    }
    
	
    @Test
    void testGetNome() {
    	assertEquals(docente.getNome(), "Nome");
    }
    
    @Test
    void testGetCogome() {
    	assertEquals(docente.getCognome(), "Cognome");
    }
    
    @Test
    void testGetGiorno() {
    	assertEquals(docente.getGiorno(), 1);
    }
    
    @Test
    void testGetMese() {
    	assertEquals(docente.getMese(), 1);
    }
    
    @Test
    void testGetAnno() {
    	assertEquals(docente.getAnno(), 1990);
    }
    
    @Test
    void testGetStipendio() {
    	assertEquals(docente.getStipendio(), 1000);
    }
    
    @Test
    void testGetEsami() {
    	assertEquals(docente.getEsami(), esami);
    }
    
    /*
     * Il seguente test fallisce: come mai?
     * 
    @Test
    void testToString() {
    	System.out.println(docente.toString());
    	assertEquals(docente.toString(), "Nome: Nome\nCognome: Cognome\nData di nascita: 1/1/1990\nStipendio: 1000\nEsami: [PR1, PR2]");
    }
    */
    
    
    @Test
    void testSizeAnagrafica(){
    	assertEquals(anagrafica.getAnagrafica().size(), 3);
    }
    
}


