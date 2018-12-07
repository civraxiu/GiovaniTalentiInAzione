package it.ytia.anagrafica;
	

import java.io.File;
import java.net.URISyntaxException;

import it.ytia.anagrafica.fx.SceneBuilder;
import it.ytia.anagrafica.logica.Anagrafica;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * Applicazione grafica per la gestione di un'anagrafica.
 * 
 * @author Livio Pompianu
 */
public class Main extends Application {
	Anagrafica anagrafica;
	
	
	@Override
	public void start(Stage primaryStage) {
		
		try {
			File file = new File(getClass().getClassLoader().getResource("anagrafica.txt").toURI());

			this.anagrafica = new Anagrafica(file);		
			
			/*
			 * La costruzione degli elementi grafici delle scene
			 * avviene in una classe separata che possiede un metodo
			 * per ogni scena da creare e riceve tramite costruttore 
			 * lo stage e l'anagrafica da aggiornare e stampare
			 */
			SceneBuilder builder = new SceneBuilder(primaryStage, anagrafica);
		
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
