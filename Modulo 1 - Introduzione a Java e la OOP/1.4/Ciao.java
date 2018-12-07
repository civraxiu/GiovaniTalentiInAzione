/*
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

/**
 * 
 * Stampa un saluto all'utente
 * 
 * @author Livio
 * @since JDK.1.0
 */
public class Ciao{
	
	public static void main(String[] args) {
   
        // Stampa il numero di argomenti ricevuti in ingresso (la lunghezza dell'array args)
		System.out.println(args.length);

        // Riceve un argomento passato dall'utente all'avvio del programma e lo stampa a video
		System.out.print("Ciao " + args[0] + "!");
	}	
}


/* 
 * Istruzioni per compilare e eseguire da terminale
 *
 * Compilare con:
 * javac NomeFile.java
 *
 * Eseguire inidcando il nome della classe e tutti gli argomenti che si desidera passare, separati da spazio
 * java NomeClasse argomento1 argomento2 argomento3
 */



