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

package it.ytia.anagrafica;
	

import java.io.File;
import java.util.List;

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
	
	@Override
	public void start(Stage primaryStage) {
		List<String> parameters = getParameters().getRaw();
		
		if (parameters.size() == 0) {
			System.out.println("Specificare un file per l'anagrafica");
			System.exit(1);
		}
		
		File file = new File(parameters.get(0));
		Anagrafica anagrafica = new Anagrafica(file);		
		
		/*
		 * La costruzione degli elementi grafici delle scene
		 * avviene in una classe separata che possiede un metodo
		 * per ogni scena da creare e riceve tramite costruttore 
		 * lo stage e l'anagrafica da aggiornare e stampare
		 */
		SceneBuilder builder = new SceneBuilder(primaryStage, anagrafica);
		builder.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
