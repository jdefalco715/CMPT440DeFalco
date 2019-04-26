import java.util.*;

public class ManWolf() {
	private static final int q0 = 0;
	private static final int q1 = 1;
	private static final int q2 = 2;
	private static final int q3 = 3;
	private static final int q4 = 4;
	private static final int q5 = 5;
	private static final int q6 = 6;
	private static final int q7 = 7;
	private static final int q8 = 8;
	private static final int q9 = 9;
	private static final int q10 = 10;  //Error state

	private int state;

	static private int [][] delta = {{q1, q3}, {q0, q2}, {q1, q3, q5}, {q2, q4}, {q3, q7}, {q2, q6}, {q5, q7}, {q4, q6, q7}, {q7, q9}, {q8}, {q10}};

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