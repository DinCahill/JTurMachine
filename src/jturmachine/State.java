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

/**
 * A State in which a JTurMachine can be.
 * 
 * A State contains a list of Operations which can be executed
 * while in this State, and selects the appropriate one, based
 * on the symbol which is read from the Tape.
 * 
 * @author Donal Cahill
 *
 */
public class State {

	String name;
	String readSymbol;
	HashMap<String, String[]> opList = new HashMap<String, String[]>();
	
	/**
	 * Class constructor.
	 * 
	 * @param name the String name of this State.
	 */
	public State(String name) {
		this.name = name;
	}
	
	
	/**
	 * @return the String name of this State.
	 */
	@Override
	public String toString() {
		return name;
	}
	
	/**
	 * Adds an executable Operation to this State.
	 * 
	 * @param inputSymbol the String symbol which must be read from the Tape for this Operation to be executed
	 * @param writeSymbol the String symbol to be written to the current Tape cell by this Operation
	 * @param moveDirection the String of the direction, "L", "R" or "N", in which the Tape will move after writing
	 * @param nextState the State which the JTurMachine will move to after moving the Tape
	 */
	public void addOperation(String inputSymbol, String writeSymbol, String moveDirection, State nextState) {
		String[] op = { writeSymbol, moveDirection, nextState.toString() };
		opList.put(inputSymbol, op);
	}
	
	/**
	 * @param readSymbol the String symbol read from the Tape
	 * @return the Operation corresponding to readSymbol for this State 
	 */
	public String[] getOperation(String readSymbol) {
		return opList.get(readSymbol);
	}
}
