import java.util.*;

public class Meter() {
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

	// Transistion function of the DFA
	static private int [][] delta = {{q1, q2, q10},
									 {q2, q3, q10},
									 {q3, q4, q9},
									 {q4, q5, q9}, 
									 {q5, q6, q9}, 
									 {q6, q7, q9}, 
									 {q7, q8, q9}, 
									 {q8, q9}, 
									 {q9}, 
									 {q9}, 
									 {q10}};

	public void reset() {
		state = q0;
	}

	public void process (String in) {
		for (int i = 0; i < in.length; i++) {
			char c = in.charAt(i);
			try {
				state = delta[state, c-'0'];
			}
			catch (ArrayIndexOutOfBoundsException ex) {
				state = q10;
			}
		}
	}

	public boolean accepted() {
		return state == q9;
	}
}