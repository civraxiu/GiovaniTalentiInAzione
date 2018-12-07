/*
 * Copyright 2018 - Nicola Atzei (atzeinicola@gmail.com)
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

public class Soluzioni {

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Esercizio 3.1 (switch)
     * 
     * Specifica
     *     Dato un numero da 1 a 12, stampare tutti i nomi dei
     *     mesi successivi, uno per ogni linea.
     *     
     * Esempio
     *     Se il mese corrente è 8, stamperà:
     *     Agosto
     *     Settembre
     *     Ottobre
     *     Novembre
     *     Dicembre
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    /*
     * Soluzione 3.1.1
     */
    public static void sol_3_1_1() {
        int mese = 8;

        switch(mese) {
            case 1: System.out.println("Gennaio");
            case 2: System.out.println("Febbraio");
            case 3: System.out.println("Marzo");
            case 4: System.out.println("Aprile");
            case 5: System.out.println("Maggio");
            case 6: System.out.println("Giugno");
            case 7: System.out.println("Luglio");
            case 8: System.out.println("Agosto");
            case 9: System.out.println("Settembre");
            case 10: System.out.println("Ottobre");
            case 11: System.out.println("Novembre");
            case 12: System.out.println("Dicembre"); break;
            default: System.out.println("Mese non valido!");
        }
    }
    
    /*
     * Soluzione 3.1.2
     */
    public static void sol_3_1_2() {
        int mese = 8;
        String risultato = "";
        
        switch(mese) {
            case 1: risultato += "Gennaio\n";
            case 2: risultato += "Febbraio\n";
            case 3: risultato += "Marzo\n";
            case 4: risultato += "Aprile\n";
            case 5: risultato += "Maggio\n";
            case 6: risultato += "Giugno\n";
            case 7: risultato += "Luglio\n";
            case 8: risultato += "Agosto\n";
            case 9: risultato += "Settembre\n";
            case 10: risultato += "Ottobre\n";
            case 11: risultato += "Novembre\n";
            case 12: risultato += "Dicembre\n"; break;
            default: risultato = "Mese non valido!\n";
        }
        System.out.println(risultato);
    }
    
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Esercizio 3.2 (switch)
     * 
     * Specifica
     *     Dato il nome di un mese, convertirlo nel suo valore numerico.
     *     
     * Esempio
     *     Se il mese corrente è "Agosto", stamperà 8
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    /*
     * Soluzione 3.2.1
     */
    public static void sol_3_2_1() {
        String mese = "Agosto";
        int meseNumerico = 0;

        switch(mese) {
            case "Gennaio": meseNumerico = 1; break;
            case "Febbraio": meseNumerico = 2; break;
            case "Marzo": meseNumerico = 3; break;
            case "Aprile": meseNumerico = 4; break;
            case "Maggio": meseNumerico = 5; break;
            case "Giugno": meseNumerico = 6; break;
            case "Luglio": meseNumerico = 7; break;
            case "Agosto": meseNumerico = 8; break;
            case "Settembre": meseNumerico = 9; break;
            case "Ottobre": meseNumerico = 10; break;
            case "Novembre": meseNumerico = 11; break;
            case "Dicembre": meseNumerico = 12; break;
        }
        if (meseNumerico == 0) {
            System.out.println("Mese non valido!");
        }
        else {
            System.out.println(meseNumerico);
        }
    }
    
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Esercizio 3.3 (while)
     * 
     * Specifica
     *     Creare un array di 5 elementi.
     *     Inizializzarlo a piacere.
     *     Stampare tutti gli elementi dell'array.
     *     
     * Esempio
     *     Output per l'array [2, 4, 5, 7, 10], dovrà stampare:
     *     Elemento in posizione 0: 2
     *     Elemento in posizione 1: 4
     *     Elemento in posizione 2: 5
     *     Elemento in posizione 3: 7
     *     Elemento in posizione 4: 10
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    
    /*
     * Soluzione 3.3.1
     */
    public static void sol_3_3_1() {
        int[] numeri = new int[] {2,4,5,7,10};
        int i = 0;

        while(i < numeri.length) {
            System.out.println(
                "Elemento in posizione " + i + ": " + numeri[i]);
            i++;    
            // oppure i = i + 1
            // oppure i += 1;
        }
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Esercizio 3.4 (cicli)
     * 
     * Specifica
     *     Dato un array di caratteri (char[]), stampare l'array come una stringa compatta
     *     
     * Esempio
     *      Output per l'array ['a', 'b', 'c', 'd', 'e' ]:
     *      { 'a' . 'b' . 'c' . 'd' . 'e' }
     * 
     * Suggerimento:
     *      utilizzare System.out.print(...) per stampare una stringa senza andare a capo
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    
    /*
     * Soluzione 3.4.1
     */
    public static void sol_3_4_1() {
        char[] caratteri = new char[] {'a','b','c','d','e','f','g'};
        
        System.out.print("{ ");
        for(int i=0; i<caratteri.length; i++) {
            System.out.print("'" + caratteri[i] + "'");
            if (i < caratteri.length-1) {
                System.out.print(" . ");
            }
        }
        System.out.print(" }");
    }
    
    /*
     * Soluzione 3.4.2
     */
    public static void sol_3_4_2() {
        char[] caratteri = new char[] {'a','b','c','d','e','f','g'};
        
        String risultato = "{ ";
        for(int i=0; i<caratteri.length; i++) {
            risultato += "'" + caratteri[i] + "'";
            if (i < caratteri.length-1) {
                risultato += " . ";
            }
        }
        risultato += " }";
        System.out.println(risultato);
    }
    
    /*
     * Soluzione 3.4.3
     */
    public static void sol_3_4_3() {
        char[] caratteri = new char[] {'a','b','c','d','e','f','g'};
        
        String risultato = "{ ";
        for(int i=0; i<caratteri.length; i++) {
            String separatore = i < caratteri.length-1 ? " . ": "";
            risultato += "'" + caratteri[i] + "'" + separatore;
        }
        risultato += " }";
        System.out.println(risultato);
    }

    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Esercizio 3.5 (for)
     * 
     * Specifica
     *     Creare un array di 5 elementi.
     *     Inizializzarlo a piacere.
     *     Stampare tutti gli elementi dell'array al contrario.
     *     
     * Esempio
     *     Output per l'array [2, 4, 5, 7, 10], dovrà stampare:
     *     Elemento in posizione 4: 10
     *     Elemento in posizione 3: 7
     *     Elemento in posizione 2: 5
     *     Elemento in posizione 1: 4
     *     Elemento in posizione 0: 2
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */
    
    /*
     * Soluzione 3.5.1
     */
    public static void sol_3_5_1() {
        int[] numeri = new int[] {2,4,5,7,10};

        for(int i=numeri.length-1; i>=0; i--) {
            System.out.println(
                "Elemento in posizione " + i + ": " + numeri[i]);
        }
    }
    
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Esercizio 3.6 (cicli)
     * 
     * Specifica
     *     Scrivere un programma che cerchi un numero n all'interno di un array
     *     di interi (fare sia una versione con break che senza)
     * 
     * Esempio
     *     Cerca 12 in [0, 19, 4, 12, 7] stamperà:
     *     Trovato in posizione 3
     *     
     *     Cerca 99 in [0, 19, 4, 12, 7] stamperà:
     *     Non trovato :(
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    /*
     * Soluzione 3.6.1 (con break)
     */
    public static void sol_3_6_1() {
        int cerca = 12;
        int[] numeri = new int[] {0, 19, 4, 12, 7};
        
        int i = 0;
        for (int n : numeri) {
            if (n == cerca) {
                System.out.println("Trovato in posizione "+i);
                break;  // non si può fare senza break
            }
            i++;
        }
        if (i == numeri.length) {
            System.out.println("Non trovato :(");
        }
    }

    /*
     * Soluzione 3.6.2
     */
    public static void sol_3_6_2() {
        int cerca = 132;
        int[] numeri = new int[] {0, 19, 4, 12, 7};
        
        boolean trovato = false;
        for (int i=0; i<numeri.length; i++) {
            if (numeri[i] == cerca) {
                System.out.println("Trovato in posizione "+i);
                trovato = true;
                break;
            }
        }
        
        if (!trovato) {
            System.out.println("Non trovato :(");
        }
    }
        
    /*
     * Soluzione 3.6.3
     *     come 3.6.2 senza break, utilizzando una bandierina
     */
    public static void sol_3_6_3() {
        int cerca = 12;
        int[] numeri = new int[] {0, 19, 4, 12, 7};
        
        boolean trovato = false;
        // notare la condizione di terminazione nel for
        for (int i=0; i<numeri.length && !trovato; i++) {
            if (numeri[i] == cerca) {
                System.out.println("Trovato in posizione "+i);
                trovato = true;
            }
        }
        
        if (!trovato) {
            System.out.println("Non trovato :(");
        }
    }
        
    /*
     * Soluzione 3.6.4
     *     simile a 3.6.3, ma la nostra bandierina è diventata un int
     *     e ci salviamo la posizione
     */
    public static void sol_3_6_4() {
        int cerca = 12;
        int[] numeri = new int[] {0, 19, 4, 12, 7};
        
        int posizione = -1;
        for (int i=0; i<numeri.length; i++) {
            if (numeri[i] == cerca) {
                posizione = i;
                i = numeri.length; // oppure break;
            }
        }
        
        if (posizione == -1) {
            System.out.println("Non trovato :(");
        }
        else {
            System.out.println("Trovato in posizione "+posizione);
        }
    }
        
    /* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
     * Esercizio 3.7 (cicli)
     * 
     * Specifica
     *     Data una stringa, contare le occorrenze del carattere 'a'
     *     Suggerimento: è possibile ottenere un char[] data una stringa utilizzando toCharArray().
     *     "ciao".toCharArray() ==> ['c', 'i', 'a', 'o']
     * 
     * Esempio
     *     Per la parola "Roma" stamperà:
     *     Trovata/e 1 occorrenza/e del carattere 'a'

     *     Per la parola "Mamma mia" stamperà:
     *     Trovata/e 3 occorrenza/e del carattere 'a'
     * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * */

    /*
     * Soluzione 3.7.1
     */
    public static void sol_3_7_1() {
        String text = "Mamma mia";
        char lettera = 'a';
        char[] caratteri = text.toCharArray();
        int occorrenze = 0;
        
        for (char ch : caratteri) {
            if (ch == lettera) occorrenze++;
        }
        System.out.println("Trovata/e "+occorrenze+" occorrenza/e del carattere '"+lettera+"'");
    }

    public static void main(String[] args) {
        
    }

}
