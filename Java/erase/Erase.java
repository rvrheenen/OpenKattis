package eraseSecurely;

import java.util.Scanner;
import java.io.PrintStream;

public class Erase {

	Scanner in;
	PrintStream out;

	EraseSecurely() {
		out = new PrintStream(System.out);
		in = new Scanner(System.in);
	}

	void start() {
		int N = in.nextInt();
		String l1 = in.next();
		String l2 = in.next();

		if (N % 2 == 0) {
			if (l1.equals(l2)) {
				out.print("Deletion succeeded");
			} else {
				out.print("Deletion failed");
			}
		} else {
			String result = "Deletion succeeded";
			for (int i = 0; i < l1.length(); i++) {
				if (l1.charAt(i) == l2.charAt(i)) {
					result = "Deletion failed";
					break;
				}
			}
			out.print(result);
		}
	}

	public static void main(String[] args) {
		new EraseSecurely().start();
	}
}
