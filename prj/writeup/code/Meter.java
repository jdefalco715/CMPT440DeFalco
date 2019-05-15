import java.util.*;

public class Meter {
	private static final int q0 = 0; // $0
	private static final int q1 = 1; // $0.25
	private static final int q2 = 2; // $0.50
	private static final int q3 = 3; // $0.75
	private static final int q4 = 4; // $1.00
	private static final int q5 = 5; // $1.25
	private static final int q6 = 6; // $1.50
	private static final int q7 = 7; // $1.75
	private static final int q8 = 8; // $2.00
	private static final int q9 = 9; // Payment
	private static final int q10 = 10; // Error state

	// Variables to hold current and previous state
	// Current state is initialized at start state
	private int state = q0, lastState;
	
	// Variable to store monetary value inserted
	// May be changed
	private double value = 0.0;

	// Transition function of the DFA
	// Input of each array follows format of {x, y, z}
	// x = 0.25 input
	// y = 0.50 input
	// z = Enter input
	static private int [][] delta = {{q1, q2, q10},			// 0
									 {q2, q3, q10},			// 1
									 {q3, q4, q9},			// 2
									 {q4, q5, q9}, 			// 3
									 {q5, q6, q9}, 			// 4
									 {q6, q7, q9}, 			// 5
									 {q7, q8, q9}, 			// 6
									 {q8, q8, q9}, 			// 7
									 {q8, q8, q9}, 			// 8
									 {q9, q9, q9}, 			// 9
									 {q10, q10, q10}};		// 10

	// Set the DFA to state 0
	public void reset() {
		state = q0;
	}

	// Process of checking input
	public void process (String in) {

		// If statements to determine next state
		// Also defines previous state
		if(in == "0.25" || in == ".25") {
			lastState = state;
			state = delta[state][0];
		} else if (in == "0.50" || in == "0.5" || in == ".5") {
			lastState = state;
			state = delta[state][1];
		} else if (in == "Enter" || in == "enter")
			lastState = state;
			state = delta[state][2];

	}

	// Return current state
	public int getState() {
		return this.state;
	}

	// Return value
	public int getValue() {
		if(state == q0)
			return 0;			// Temp value
		else if (state == q1)
			return 1;			// Temp value
		else return 2; 			// Temp value
	}

	// Time value at each state
	public String time(int x) {
		return "";
	}

	public boolean accepted() {
		return state == q9;
	}
}