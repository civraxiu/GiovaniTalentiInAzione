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

public class Caldaia {
	
	private int temperatura;
	private boolean accesa;
	public static final int TEMPERATURA_PREDEFINITA = 25;

	public Caldaia() {
		this(false, TEMPERATURA_PREDEFINITA);
	}

	public Caldaia(int temperatura) {
		this(false, temperatura);
	}

	public Caldaia(boolean accesa) {
		this(accesa, TEMPERATURA_PREDEFINITA);
	}
	
	public Caldaia(int temperatura, boolean accesa) {
		this(accesa, temperatura);
	}
	
	public Caldaia(boolean accesa, int temperatura) {
		this.accesa = accesa;
		this.temperatura = temperatura;		
	}

	// GETTER e SETTER
	public boolean getAccesa() {	// oppure isAccesa()
		return accesa;
	}
	
	public void setAccesa(boolean b) {
		accesa = b;
	}

	public int getTemperatura() {
		return temperatura;
	}
	
	public void setTemperatura(int t) {
		temperatura = t;
	}
	

	public void on() {
		if (accesa == true) {
			System.out.println("La caldaia è già accesa");
		}
		accesa = true;
	}

	public void off() {
		if (accesa == false) {
			System.out.println("La caldaia è già spenta");
		}
		accesa = false;		
	}

	public void toggle() {
		accesa = !accesa;
	}

	public boolean isOn() {
		return accesa;
	}

	public boolean isOff() {
		return !accesa;
	}

	public void incrementa() {
		incrementa(1);
	}

	public void incrementa(int n) {
		if(isOn()) {
			temperatura += n;			
		}
	}

	public void decrementa() {
		decrementa(1);
	}

	public void decrementa(int n) {
		incrementa(-n);
	}

	public void stampa() {
		String accesaStr = isOn()? "accesa": "spenta";
		System.out.println(
				"Stato: "+accesaStr+". Temperatura: "+temperatura+".");
	}
}
