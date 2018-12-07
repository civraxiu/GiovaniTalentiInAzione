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

import java.util.Random;

public class Simulatore {

	/**
	 * Restituisce un numero tra {@code min} (incluso) e {@code max} (incluso).
	 * @param min numero minimo dell'intervallo (incluso)
	 * @param max numero massimo dell'intervallo (escluso)
	 * @return un numero casuale tra {@code min} (incluso) e {@code max} (escluso)
	 */
	public static int nextInt(int min, int max) {
		Random rand = new Random();
		return rand.nextInt(max-min) + min;
	}

	/**
	 * Restituisce un numero tra {@code min} e {@code max} (inclusi).
	 * Uguale a {@code Simulatore.nextInt(min, max+1)}.
	 * @param min numero minimo dell'intervallo (incluso)
	 * @param max numero massimo dell'intervallo (incluso)
	 * @return un numero casuale tra {@code min} e {@code max} (inclusi)
	 */
	public static int nextIntInclusive(int min, int max) {
		return nextInt(min, max+1);
	}
	
	/**
	 * Restituisce un carattere casuale compreso tra 'a' e 'z'
	 * @return un carattere casuale tra 'a' e 'z'
	 */
	public static char nextChar() {
		return (char) nextIntInclusive('a', 'z');
	}
	
	public static void main(String[] args) {
		
		int[] lanci = new int[10];

		for (int i=0; i<lanci.length; i++) {
			lanci[i] = nextIntInclusive(1, 6);
		}
		
		for (int n : lanci) {
			System.out.print(n + " ");
		}
	}
}
