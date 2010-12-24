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

/**
 * An operation which can be executed on a JTurMachine.
 * 
 * @author Donal Cahill
 */
public class Operation {

	String writeSymbol;
	String moveDirection;
	State nextState;
	
	/**
	 * 
	 * @param writeSymbol the String symbol to be written to the current Tape cell
	 * @param moveDirection the String of the direction, "L", "R" or "N", in which the Tape will move after writing
	 * @param nextState the State which the JTurMachine will move to after moving the Tape
	 */
	public Operation(String writeSymbol, String moveDirection, State nextState) {
		this.writeSymbol = writeSymbol;
		this.moveDirection = moveDirection;
		this.nextState = nextState;
	}
}
