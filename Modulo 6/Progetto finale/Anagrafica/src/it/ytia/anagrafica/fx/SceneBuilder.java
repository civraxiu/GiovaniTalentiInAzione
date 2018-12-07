package it.ytia.anagrafica.fx;

import java.util.ArrayList;
import java.util.TreeSet;

import it.ytia.anagrafica.Main;
import it.ytia.anagrafica.logica.Anagrafica;
import it.ytia.anagrafica.logica.persone.Docente;
import it.ytia.anagrafica.logica.persone.Impiegato;
import it.ytia.anagrafica.logica.persone.Persona;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;


/**
 * L'applicazione è composta da tre scene:
 * 
 * 1) La scena principale contiene il menù per selezionare
 * quale operazione vuole svolgere l'utente.
 * 
 * 2) La scena di input richiede all'utente di inserire i 
 * dati sulle diverse tipologie di persone
 * 
 * 3) La scena di output stampa i data dell'anagrafica
 *
 */
public class SceneBuilder {
	private Stage primaryStage;
	private Anagrafica anagrafica;
	
	private Scene mainScene;
	private Scene inputScene;
	
	
	public SceneBuilder(Stage primaryStage, Anagrafica anagrafica){
		this.primaryStage = primaryStage;
		this.anagrafica = anagrafica;
		
		mainScene = this.buildMainScene();
		inputScene = this.buildInputScene();
		
		// Visualizza lo stage impostando come scena attuale quella principale
		primaryStage.setScene(mainScene);
		primaryStage.setTitle("Anagrafica");
        primaryStage.show();
	}
	
	
	
	private Scene buildMainScene() {
		
		Button mainToInput = new Button("Modifica Anagrafica");
		Button mainToOutput = new Button("Visualizza Anagrafica");

	
		// Costruiamo il pannello di base che conterrà tutti gli elementi della scena
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        
        // Definiamo l'oggetto scena da rendere in uscita
		Scene mainScene = new Scene(grid, 500, 400);
        
		
		// Creiamo e aggiungiamo tutti gli elementi al pannello (e quindi alla scena)
        Text scenetitle = new Text("Anagrafica");
        scenetitle.setId("welcome-text");
        scenetitle.setTextAlignment(TextAlignment.CENTER);
        grid.add(scenetitle, 0, 0, 1, 1);

        grid.add(mainToInput, 0, 1);
        grid.add(mainToOutput, 0, 2);
        		
        mainScene.getStylesheets().add
        (getClass().getClassLoader().getResource("style.css").toExternalForm());
        
        mainToInput.setOnAction(new EventHandler<ActionEvent>() {
          	 
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(inputScene);
            }
        });
        
        mainToOutput.setOnAction(new EventHandler<ActionEvent>() {
         	 
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(buildOutputScene());
            }
        });
        
        
		return mainScene;
	}
	
	
	
	private Scene buildInputScene() {
		Button inputToMain = new Button("Indietro");
		
		Button aggiungiPersona = new Button("Aggiungi");
		
		
		// Costruiamo il pannello di base che conterrà tutti gli elementi della scena
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        
        // Definiamo l'oggetto scena da rendere in uscita
		Scene inputScene = new Scene(grid, 500, 400);
        
		
		// Creiamo e aggiungiamo tutti gli elementi al pannello (e quindi alla scena)
        Text scenetitle = new Text("Aggiungi");
        scenetitle.setId("welcome-text");
        grid.add(scenetitle, 0, 0, 2, 1);
        		
        inputScene.getStylesheets().add
        (getClass().getClassLoader().getResource("style.css").toExternalForm());
		
        
        // Nome
        Label labelNome = new Label("Nome:");
        VBox vNome = new VBox();
        vNome.setAlignment(Pos.CENTER_RIGHT);
        vNome.getChildren().add(labelNome);
        grid.add(vNome, 0, 2);
        TextField nomeTextField = new TextField();
        grid.add(nomeTextField, 1, 2);
        
        // Cognome
        Label labelCognome = new Label("Cognome:");
        VBox vCognome = new VBox();
        vCognome.setAlignment(Pos.CENTER_RIGHT);
        vCognome.getChildren().add(labelCognome);
        grid.add(vCognome, 0, 3);
        TextField cognomeTextField = new TextField();
        grid.add(cognomeTextField, 1, 3);
        
        // Giorno
        Label labelGiorno = new Label("Giorno:");
        VBox vGiorno = new VBox();
        vGiorno.setAlignment(Pos.CENTER_RIGHT);
        vGiorno.getChildren().add(labelGiorno);
        grid.add(vGiorno, 0, 4);
        TextField giornoTextField = new TextField();
        grid.add(giornoTextField, 1, 4);
        
        // Mese
        Label labelMese = new Label("Mese:");
        VBox vMese = new VBox();
        vMese.setAlignment(Pos.CENTER_RIGHT);
        vMese.getChildren().add(labelMese);
        grid.add(vMese, 0, 5);
        TextField meseTextField = new TextField();
        grid.add(meseTextField, 1, 5);
        
        // Anno
        Label labelAnno = new Label("Anno:");
        VBox vAnno = new VBox();
        vAnno.setAlignment(Pos.CENTER_RIGHT);
        vAnno.getChildren().add(labelAnno);
        grid.add(vAnno, 0, 6);
        TextField annoTextField = new TextField();
        grid.add(annoTextField, 1, 6);
        
        // Stipendio
        Label labelStipendio = new Label("Stipendio:");
        VBox vStipendio = new VBox();
        vStipendio.setAlignment(Pos.CENTER_RIGHT);
        vStipendio.getChildren().add(labelStipendio);
        grid.add(vStipendio, 0, 7);
        TextField stipendioTextField = new TextField();
        grid.add(stipendioTextField, 1, 7);
        
        // Esami
        Label labelEsami = new Label("Esami:");
        VBox vEsami = new VBox();
        vEsami.setAlignment(Pos.CENTER_RIGHT);
        vEsami.getChildren().add(labelEsami);
        grid.add(vEsami, 0, 8);
        TextField esamiTextField = new TextField();
        grid.add(esamiTextField, 1, 8);
        
        grid.add(inputToMain, 0, 9);
        grid.add(aggiungiPersona, 1, 9);
        
        inputToMain.setOnAction(new EventHandler<ActionEvent>() {
         	 
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(mainScene);
            }
        });
        
        
        aggiungiPersona.setOnAction(new EventHandler<ActionEvent>() {
        	 
            @Override
            public void handle(ActionEvent e) {
                
                if(! (esamiTextField.getText().equals(""))) {
                	
                	String[] esamiString = esamiTextField.getText().split("-");
                	ArrayList<String> esamiList = new ArrayList<>(); 
                	for(String ex : esamiString) {
                		esamiList.add(ex);
                	}
                	
                	anagrafica.addPersona(new Docente(
                			nomeTextField.getText(),
                			cognomeTextField.getText(),
                			Integer.parseInt(giornoTextField.getText()),
                			Integer.parseInt(meseTextField.getText()),
                			Integer.parseInt(annoTextField.getText()),
                			Integer.parseInt(stipendioTextField.getText()),
                			esamiList
                			));                
                }
                
                else if(! (stipendioTextField.getText().equals(""))) {
                	                	
                	anagrafica.addPersona(new Impiegato(
                			nomeTextField.getText(),
                			cognomeTextField.getText(),
                			Integer.parseInt(giornoTextField.getText()),
                			Integer.parseInt(meseTextField.getText()),
                			Integer.parseInt(annoTextField.getText()),
                			Integer.parseInt(stipendioTextField.getText())
                			));                
                }
                
                else{
                	anagrafica.addPersona(new Persona(
            			nomeTextField.getText(),
            			cognomeTextField.getText(),
            			Integer.parseInt(giornoTextField.getText()),
            			Integer.parseInt(meseTextField.getText()),
            			Integer.parseInt(annoTextField.getText())
            			));                	
                }
            }
        });
        
        
		return inputScene;
	}
	
	
	
	private Scene buildOutputScene() {
		final double MAX_WIDTH = 200;

		Button outputToMain = new Button("Indietro");
		
		// Costruiamo il pannello di base che conterrà tutti gli elementi della scena
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(25, 25, 25, 25));
        pane.setPadding(new Insets(10, 10, 10, 10));
        
        // Definiamo l'oggetto scena da rendere in uscita
		Scene outputScene = new Scene(pane, 500, 400);
		outputScene.getStylesheets().add
        (getClass().getClassLoader().getResource("style.css").toExternalForm());
        
		
		// Creiamo e aggiungiamo tutti gli elementi al pannello (e quindi alla scena)
        Text scenetitle = new Text("Visualizza");
        scenetitle.setId("welcome-text");
        pane.setTop(scenetitle);
        pane.setBottom(outputToMain);
        
        // Aggiungiamo tutte le Persone        
        TreeSet<Persona> elements = anagrafica.getAnagrafica();        
        
        VBox boxes = new VBox(10);
    	boxes.setMaxWidth(MAX_WIDTH);
    	
    	ArrayList<String> persons = new ArrayList<>();

    	for(Persona p : elements) {
    		persons.add(p.toString());
    	}
        
    	ListView<String> list = new ListView<String>();
    	ObservableList<String> items = FXCollections.observableArrayList (persons);
    	list.setItems(items);
    	pane.setCenter(list);
        
        
        outputToMain.setOnAction(new EventHandler<ActionEvent>() {
         	 
            @Override
            public void handle(ActionEvent e) {
                primaryStage.setScene(mainScene);
            }
        });
        
        
		return outputScene;
	}
}
