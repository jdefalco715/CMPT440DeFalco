import java.io.*;

public class testProgram{
	public static void main (String[] args) throws IOException {

		System.out.println("Enter test input:");

		Meter m = new Meter(); //DFA
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));       // Standard input
	
		String s = in.readLine();
		while (s!=null) {
			m.reset();
			m.process(s);
			if(m.accepted()) System.out.println(s);
			s = in.readLine();
		}
	}
}