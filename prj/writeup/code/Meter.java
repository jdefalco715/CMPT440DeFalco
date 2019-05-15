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

	private int state;
	private double value = 0.0;

	// Transistion function of the DFA
	// Input od each array follows format of {x, y, z}
	// x = 0.25 input
	// y = 0.50 input
	// z = Enter input
	static private int [][] delta = {{q1, q2, q10},
									 {q2, q3, q10},
									 {q3, q4, q9},
									 {q4, q5, q9}, 
									 {q5, q6, q9}, 
									 {q6, q7, q9}, 
									 {q7, q8, q9}, 
									 {q8, q8, q9}, 
									 {q8, q8, q9}, 
									 {q9, q9, q9}, 
									 {q10, q10, q10}};

	// Set the DFA to state 0
	public void reset() {
		state = q0;
	}

	// Process of checking input
	public void process (String in) {

		// If statements to determine next state
		if(in == "0.25" || in == ".25") {
			state = delta[state, 0];
		} else if (in == "0.50" || in == "0.5" || in == ".5") {
			state = delta[state, 1];
		} else if (in == "Enter" || in == "enter")
			state = delta[state, 2];

	}

	// Return current state
	public int getState() {
		return this.state;
	}

	// Return value
	public int getValue() {
		if(state = q0)
			return 0.00;
		else if (state = q1)
			return 
	}

	// Time value at each state
	public String time(int x) {

	}

	public boolean accepted() {
		return state == q9;
	}
}