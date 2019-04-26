import java.io.*;

public class driverDFA {
	public static void main (String[] args) throws IOException {

		ManWolf m = new ManWolf(); //DFA
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