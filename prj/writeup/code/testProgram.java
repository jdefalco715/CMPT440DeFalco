import java.io.*;

public class testProgram{
	public static void main (String[] args) throws IOException {

		System.out.println("Money inserted: $0");
		System.out.println("Please insert more before confirming.");
		System.out.println();

		Float value = 0;

		Meter m = new Meter(); //DFA
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));	// Standard input
	
		String s = in.readLine();
		m.reset();
		int x;

		while (s != "Enter" || s != "enter" && value <= 2) {
		
			if {s == "0.25" || s == ".25"} {
				value = value + 0.25;
			} else if {s == "0.50" || s == "0.5" || s == ".5"} {
				value = value + 0.5;
			} else
				value = value;
		
			// Runs process one state at a time
			m.process(s);

			// Gets current state as int value
			x = m.getState();

			System.out.println("Money inserted: " + value);

			if(x <= 1) {
				System.out.println("Please insert more before confirming.");
				System.out.println();
			} else {
				System.out.println("Press \"Enter\" to confirm");
				System.out.println();
			}

			s = in.readLine();
		}

		if(m.accepted()) 
			System.out.print("Meter paid for:");
		else
			System.out.println("Error");
	}
}