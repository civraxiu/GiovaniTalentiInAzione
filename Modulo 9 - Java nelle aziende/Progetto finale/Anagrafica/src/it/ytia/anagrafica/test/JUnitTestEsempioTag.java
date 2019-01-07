package it.ytia.anagrafica.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


public class JUnitTestEsempioTag {

    @BeforeAll
    static void initAll() {
    	System.out.println("Test eseguito (una sola volta) come primo test");
    }

    @BeforeEach
    void init() {
    	System.out.println("Test eseguito prima di eseguire ogni nuovo test");
    }

    @Test
    void succeedingTest() {
    	System.out.println("Un test eseguito con successo");
    }
    
    @Test
    void otherTest() {
    	System.out.println("Un altro test eseguito con successo");
    }

/*    
    @Test
    void failingTest() {
        fail("Un test che fallisce");
    }
*/
    
    @Test
    @Disabled("for demonstration purposes")
    void skippedTest() {
        // not executed
    	System.out.println("Questo messaggio non verrà stampato, il test è disabilitato");
    }
        

    @AfterEach
    void tearDown() {
    	System.out.println("Test eseguito dopo aver eseguito ogni nuovo test");
    }

    @AfterAll
    static void tearDownAll() {
    	System.out.println("Test eseguito (una sola volta) come ultimo test");
    }
	
	
}
