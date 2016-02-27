import java.io.PrintStream;
import java.util.Scanner;

public class SimonSays {

	PrintStream out;
	Scanner in;
	String discard;

	SimonSays() {
		out = new PrintStream(System.out);
		in = new Scanner(System.in);
	}

	void start() {
		int N = in.nextInt();
		int counter = 0;
		String[] commands = new String[N + 1];

		for (int i = 0; i <= N; i++) {
			commands[i] = in.nextLine();
		}
		for (int i = 1; i <= N; i++) {
			String line = commands[i];
			if (line.length() > 10) {
				if (line.substring(0, 10).equals("Simon says")) {
					out.println(line.subSequence(11, line.length()));
				} 
			} 
		}
	}

	public static void main(String[] args) {
		new SimonSays().start();
	}
}
