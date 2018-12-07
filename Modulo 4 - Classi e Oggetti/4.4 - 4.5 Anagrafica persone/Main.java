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

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {

		Persona nicola = new Persona("Nicola", "Atzei", 11, 9, 2001);
		Persona nicola2 = new Persona("Nicola", "Rossi", 11, 9, 2001);
		Persona luca = new Persona("Luca", "Atzei", 11, 9, 2001);
		Impiegato francesco = new Impiegato("Francesco", "Bianchi", 17, 9, 1988, 1900);
		Impiegato nicolaImp = new Impiegato(nicola, 1600);
		
		Anagrafica anagrafica = new Anagrafica(10);
		//[null,null,null,null,null,null,null,null,null,null]
		int inserimenti = anagrafica.add(nicola, luca, nicola2, nicola);
		System.out.println("Inserimenti: "+inserimenti);
		anagrafica.add(nicola);
		anagrafica.add(nicolaImp);
		//[nicola,luca,nicola,francesco,null,null,null,null,null]
	}
}



