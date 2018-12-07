package it.ytia.anagrafica.logica;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

import it.ytia.anagrafica.logica.persone.Docente;
import it.ytia.anagrafica.logica.persone.Impiegato;
import it.ytia.anagrafica.logica.persone.Persona;


/** 
 * Classe di esempio per la gestione di un'anagrafica.
 * 
 * @author Livio
 *
 */
public class Anagrafica {
	private TreeSet<Persona> anagrafica;
	private Scanner sc;
	private File filePath;

	/** 
	 * Costruttore che inizializza l'anagrafica partendo da un
	 * file di testo fornito in input.
	 * 
	 * @param filePath Percorso e nome del file da utilizzare per l'inizializzazione
	 */
	public Anagrafica(File filePath){		
		this(filePath, new Scanner(System.in));
	}
	
	
	/** 
	 * Costruttore che inizializza l'anagrafica partendo da un
	 * file di testo fornito in input.
	 * 
	 * @param filePath Percorso e nome del file da utilizzare per l'inizializzazione
	 */
	public Anagrafica(File filePath, Scanner sc){
		
		// Salvataggio del filePath
		this.filePath = filePath;
		
		// Inizializzazione dello scanner per l'acquisizione dell'input da tastiera
		this.sc = sc;
		
		// Inizializzazione dell struttura anagrafica
		anagrafica = new TreeSet<>();
		
		// Spostiamo le operazioni di lettura da file in una funzione privata di lavoro
		initFromFile();
	}
	
	
	
	/** 
	 * Funzione interna per il caricamento dei valori dell'anagrafica da file
	 * 
	 * @param filePath Percorso e nome del file da utilizzare per l'inizializzazione
	 * */
	private void initFromFile() {
		
		/* 
		 * Try with resources: le risorse vengono dichiarate dentro il try e chiuse
		 * automaticamente da Java, non è necessario utilizzare finally
		 */
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
		
			String l;
			while((l = reader.readLine()) != null) {				
				/* 
				 * Ogni volta che nella stringa compare il carattere " " taglia il pezzo
				 * corrente di stringa e lo inserisce in una nuova posizione dell'array
				 */
				String[] temp = l.split(" "); 
				
				switch(temp.length) {
					case 5: anagrafica.add(new Persona(temp[0], temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4])));
					break;
					case 6: anagrafica.add(new Impiegato(temp[0], temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), Integer.parseInt(temp[5])));
					break;
					default: throw new RuntimeException("Caricamento anagrafica fallito - Formattazione del file " + filePath + " non valida");
				}
			}
			
		} catch(IOException e) {
			throw new RuntimeException("Caricamento anagrafica fallito - Errore I/O nella lettura del file " + filePath);
		}
	}
	
	
	
	/** 
	 * Salva il contenuto corrente della struttra dati anagrafica in un file 
	 * di output fornito dal chiamante
	 * 
	 * @param filePath Percorso e nome del file da utilizzare per il salvataggio dei dati
	 */
	public void salvaAnagrafica(String filePath) {
		
		/* 
		 * Try with resources: le risorse vengono dichiarate dentro il try e chiuse
		 * automaticamente da Java, non è necessario utilizzare finally
		 */
		try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
			
			/*
			 * anagrafica è un HashSet quindi implementa l'interfaccia Iterable.
			 * Tutti gli oggetti che implementano Iterable possono essere navigati
			 * attraverso l'utilizzo di un "For Each". Ogni nuova persona presente
			 * nella struttura viene messa a disposizione nell'oggetto "p".
			 */
			for(Persona p : anagrafica) {

				String sep = " ";
				
				/*
				 * Di ogni persona "p" writer richiama i metodi get e stampa 
				 * la rappresentazione testuale del attributo.
				 */
				String temp = p.getNome() + sep + p.getCognome() + sep + p.getGiorno() + sep + p.getMese() + sep + p.getAnno();
				
				// Se si tratta di un impiegato dobbiamo fornire anche lo stipendio
				if(p instanceof Impiegato) {
					Impiegato i = (Impiegato) p;
					temp += sep + i.getStipendio();
				}
				
				// Se si tratta di un docente dobbiamo fornire anche gli esami
				if(p instanceof Docente) {
					Docente d = (Docente) p;
					ArrayList<String> esami = d.getEsami();
					for(String e : esami) {
						temp += "-" + e;
					}
					temp = temp.replaceFirst("-", sep);
				}
				
				// Effettua la stampa su file
				writer.println(temp);
			}
			
		} catch (IOException e) {			
			throw new RuntimeException("Salvataggio anagrafica fallito - Errore I/O nella scrittura del file " + filePath);
		}
	}
	

	
	/**
	 * Aggiunge una nuova persona all'anagrafica
	 * 
	 * @param p Persona da aggiungere alla struttura
	 */
	public void addPersona(Persona p) {
		
		anagrafica.add(p);
		
	}
	
	
	
	/**
	 * Aggiunge una nuova persona all'anagrafica richiedendo i dati in input da tastiera
	 */
	public void addPersona() {		
		/*
		 * Richiama i metodi per l'acquisizione degli attributi
		 * e inizializza una nuova persona che viene inserita nella struttura
		 */
		boolean result = false;
		while(!result)
			result = anagrafica.add(new Persona(inputName(), inputSurname(), inputDay(), inputMonth(), inputYear()));
	}



	/**
	 * Aggiunge un nuovo impiegato all'anagrafica richiedendo i dati in input da tastiera
	 */
	public void addImpiegato() {
		
		/*
		 * Richiama i metodi per l'acquisizione degli attributi
		 * e inizializza un nuovo Impiegato che viene inserito nella struttura
		 */
		boolean result = false;
		while(!result)
			result = anagrafica.add(new Impiegato(inputName(), inputSurname(), inputDay(), inputMonth(), inputYear(), inputSalary()));
	}
	
	
	
	/**
	 * Aggiunge un nuovo Docente all'anagrafica richiedendo i dati in input da tastiera
	 */
	public void addDocente() {
		
		/*
		 * Richiama i metodi per l'acquisizione degli attributi
		 * e inizializza un nuovo Impiegato che viene inserito nella struttura
		 */
		boolean result = false;
		while(!result)
			result = anagrafica.add(new Docente(inputName(), inputSurname(), inputDay(), inputMonth(), inputYear(), inputSalary(), inputExams()));
	}
	
	
	
	/**
	 * Rende il TreeSet al chiamante
	 */
	public TreeSet<Persona> getAnagrafica(){
		return this.anagrafica;
	}
	
	
	
	private String inputName() {
		System.out.print("Inserisci il nome: ");
		return sc.next();
	}

	
	
	private String inputSurname() {
		System.out.print("Inserisci il cognome: ");
		return sc.next();
	}

	
	
	private int inputDay() {
		System.out.print("Inserisci il giorno di nascita: ");
		return sc.nextInt();
	}

	
	
	private int inputMonth() {
		System.out.print("Inserisci il mese di nascita: ");
		return sc.nextInt();
	}
	
	
	
	private int inputYear() {
		System.out.print("Inserisci l'anno di nascita: ");
		return sc.nextInt();
	}
	
	
	
	private int inputSalary() {
		System.out.print("Inserisci lo stipendio: ");
		return sc.nextInt();
	}
	
	
	
	private ArrayList<String> inputExams() {
		System.out.print("Inserisci gli esami ( separati da \"-\" ): ");
		
		// Ogni esame viene salvato in una nuova posizione dell'array
		String[] exams = sc.next().split("-");
		
		/* Ora l'array "viene convertito" in un ArrayList per avere compatibilità
		 * con il tipo di ritorno del metodo (e con l'attributo della classe Docente)
		 * In primo luogo si inizializza la struttura ArrayList:
		 */
		ArrayList<String> result = new ArrayList<>();
		
		// Si visitano tutte le posizioni dell'array e si salvano nell'ArrayList
		for(String e : exams) {
			result.add(e);
		}
				
		// L'ArrayList è pronto!
		return result;
	}
}