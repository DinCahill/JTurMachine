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
import jturmachine.*;
import junit.framework.TestCase;
import java.util.HashMap;

/**
 * Unit test for the JTurMachine. Runs 3- and 4-state busy beavers.
 * 
 * @author Donal Cahill
 */
public class JTurMachineTest extends TestCase {
	
	// Define the variables
	String[] dictionary = {"0", "1"};
	String blank;
	State A;
	State B;
	State C;
	State D;
	State HALT;
	HashMap<String, State> stateList;
	JTurMachine machine;
	
	/**
	 * @param arg0
	 */
	/*
	public JTurMachineTest(String arg0) {
		super(arg0);
	}
	*/

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	/*
	protected void setUp() throws Exception {
		super.setUp();
	}
	*/
	/**
	 * Runs the 3-state busy beaver program. Checks for the correct result
	 */
	public void test_three_state_busy_beaver() {
		System.out.println("3-State Busy Beaver:\n");
		// An empty string is equivalent to 0
		blank = "0";
		// Three States
		A = new State("A");
		B = new State("B");
		C = new State("C");
		HALT = new State("HALT");
		// Each State needs dictionary.size() operations
		// A operations
		A.addOperation(dictionary[0], dictionary[1], "R", B);
		A.addOperation(dictionary[1], dictionary[1], "L", C);
		// B's operations
		B.addOperation(dictionary[0], dictionary[1], "L", A);
		B.addOperation(dictionary[1], dictionary[1], "R", B);
		// C's operations
		C.addOperation(dictionary[0], dictionary[1], "L", B);
		C.addOperation(dictionary[1], dictionary[1], "R", HALT);
		
		stateList = new HashMap<String, State>();
		stateList.put("A", A);
		stateList.put("B", B);
		stateList.put("C", C);
		stateList.put("HALT", HALT);
		
		machine = new JTurMachine(dictionary[0], dictionary, null, stateList.get("A"), stateList);
		machine.execute();
		System.out.println();
		assertEquals(machine.getTapeString(), "111111");
	}

	/**
	 * Runs the 4-state busy beaver program. Checks for the correct result.
	 */
	public void test_four_state_busy_beaver() {
		System.out.println("4-State Busy Beaver:\n\n");
		// An empty string is equivalent to 0
		blank = "0";
		// Three States
		A = new State("A");
		B = new State("B");
		C = new State("C");
		D = new State("D");
		HALT = new State("HALT");
		// Each State needs dictionary.size() operations
		// A operations
		A.addOperation(dictionary[0], dictionary[1], "R", B);
		A.addOperation(dictionary[1], dictionary[1], "L", B);
		// B's operations
		B.addOperation(dictionary[0], dictionary[1], "L", A);
		B.addOperation(dictionary[1], dictionary[0], "L", C);
		// C's operations
		C.addOperation(dictionary[0], dictionary[1], "R", HALT);
		C.addOperation(dictionary[1], dictionary[1], "L", D);
		// D's operations
		D.addOperation(dictionary[0], dictionary[1], "R", D);
		D.addOperation(dictionary[1], dictionary[0], "R", A);
		
		stateList = new HashMap<String, State>();
		stateList.put("A", A);
		stateList.put("B", B);
		stateList.put("C", C);
		stateList.put("D", D);
		stateList.put("HALT", HALT);
		
		machine = new JTurMachine(dictionary[0], dictionary, null, stateList.get("A"), stateList);
		machine.execute();
		System.out.println();
		assertEquals(machine.getTapeString(), "10111111111111");
	}
	
	
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	/*
	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	*/
	


}
