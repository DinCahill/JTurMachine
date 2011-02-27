/*******************************************************************************
 * Copyright (c) 2010 Donal Cahill.
 * 
 * This file is part of JTurMachine.
 * 
 * JTurMachine is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * JTurMachine is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with JTurMachine.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package jturmachine;
import java.util.LinkedList;

/**
 * A simulation of a length of tape, divided into cells.
 * 
 * This Tape can move left and right, one cell at a time,
 * and read to and write from cells.
 *  
 * @author Donal Cahill
 */
public class Tape {

	LinkedList<String> tapeList;
	String currentSymbol;
	String blank;
	int i;
	
	/**
	 * Class constructor.
	 * i is the int index of the cell being read.
	 * 
	 * @param blank the String symbol which represents a blank cell on this Tape
	 */
	public Tape(String blank) {
		tapeList = new LinkedList<String>();
		i = 0;
		this.blank = blank;
		tapeList.add(this.blank);
		currentSymbol = this.blank;
		
		/*	I'm sure this isn't needed now
			this.move("L");
			this.move("R");
		 */
	}
	
	/**
	 * Move this Tape one cell to the left, or right, or not at all.
	 * 
	 * @param moveDirection the String of the direction in which to move this Tape: "L", "R" or "N"
	 */
	public void move(String moveDirection) {
		if (moveDirection.equals("R")) {
			 /*
			  * Try to read the cell to the right.
			  * If that cell doesn't exist in the LinkedList, add an entry to
			  * the end of it, and read it.
			  */ 
			i++;
			try {
				currentSymbol = tapeList.get(i);
			} catch (IndexOutOfBoundsException e) {
				tapeList.addLast(blank);
				currentSymbol = tapeList.get(i);
			}
		} else if (moveDirection.equals("L")) {
			/*
			 * Try to read the cell to the left.
			 * If that cell doesn't exist in the LinkedList, 
			 */
			i--;
			try {
				currentSymbol = tapeList.get(i);
			} catch (IndexOutOfBoundsException e) {
				tapeList.addFirst(blank);
				i++;
				currentSymbol = tapeList.get(i);
			}
			// If the move direction was invalid:
		} else {
			System.out.println(moveDirection + " isn't a valid move direction. This machine shall now DIE.");
			System.exit(0);
		}
		
	}
	
	/**
	 * @return the String symbol in the current cell on this Tape
	 */
	public String read() {
		return currentSymbol;
	}
	
	/**
	 * Writes a String symbol to this Tape
	 * 
	 * @param writeSymbol the String symbol to write to this Tape
	 */
	public void write(String writeSymbol) {
		tapeList.set(i, writeSymbol);
	}
	
	/**
	 * @return a String of symbols from the portion of this Tape which has been accessed
	 */
	@Override
	public String toString() {
		String tapeString = "";
		for (String s : tapeList) {
			tapeString = tapeString + s;
		}
		return tapeString;
	}
}
