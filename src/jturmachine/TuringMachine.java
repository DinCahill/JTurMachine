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

import java.util.HashMap;

// import java.util.HashMap;

/**
 * An implementation of the Turing Machine.
 * 
 * @author Donal Cahill
 */
public class TuringMachine {
	
	String[] dictionary;
	Tape tape;
	State currentState;
	HashMap<String, State> stateList;
	String readSymbol;
	
	/**
	 * Class constructor.
	 * 
	 * @param dictionary an array of Strings, one of which can be written to any cell
	 * @param tape the Tape with which this TuringMachine is initially loaded. If tape points to null, a blank tape is used  
	 * @param initialState the initial State of this TuringMachine
	 * @param stateList the HashMap linking String names of States and their variable names
	 */
	public TuringMachine(String blank, String[] dictionary, Tape tape, State initialState, HashMap<String, State> stateList) {
		this.dictionary = dictionary;
		// If a tape is specified, use it, else use a blank tape.
		if (tape != null) {
			this.tape = tape;
		} else {
			this.tape = new Tape(blank);
		}
		this.currentState = initialState;
		this.stateList = stateList;
	}
	
	/**
	 * The main loop of this TuringMachine.
	 * 
	 * Keeps executing operations until the State called "HALT",
	 * upon which this TuringMachine exits the and prints some
	 * final information.
	 */
	public void execute() {
		while (!currentState.name.equals("HALT")) {
			// Print the State's name and the contents of the Tape
			System.out.println(currentState.name + " " + tape.toString());
			// Read from the tape
			readSymbol = tape.read();
			/*
			 * Get the information about the operation to be performed, and
			 * store it in a String array.
			 * 0 - The symbol to be written
			 * 1 - The direction in which to move
			 * 2 - The next state
			 */
			String currentOperation[] = currentState.getOperation(readSymbol);
			// Write to the tape
			tape.write(currentOperation[0]);
			// Move the tape
			tape.move(currentOperation[1]);
			// Go to the next state
			currentState = stateList.get(currentOperation[2]);
		}
		System.out.println("HALT " + tape.toString());
		System.out.println("Length: " + tape.toString().length());
		System.out.println("Done!");
	}
	
	/**
	 * @return a String of symbols from the portion of this TuringMachine's Tape which has been accessed
	 */
	public String getTapeString() {
		return tape.toString();
	}

}
