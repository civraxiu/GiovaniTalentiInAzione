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

public class TestBicycle {
	public static void main(String[] args) {
		
		Bicycle myBicycle = new Bicycle("Rambo");
				
		int v0 = myBicycle.getSpeed();
		System.out.println(v0);
		
		myBicycle.changeSpeed(-25);
		
		int v1 = myBicycle.getSpeed();
		System.out.println(v1);
		
	}
}
