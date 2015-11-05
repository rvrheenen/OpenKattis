package trollHunt;

import java.io.PrintStream;
import java.util.Scanner;

public class TrollHunt {

	Scanner in;
	PrintStream out;

	TrollHunt(){
		out = new PrintStream(System.out);
		in = new Scanner(System.in);
	}

	void start(){
		int b = in.nextInt() - 1;
		int k = in.nextInt();
		int g = in.nextInt();
	
		int daily = k/g;
		int days = b/daily;
		days += (b%daily != 0) ? 1 : 0;
		out.print(days);
	}

	public static void main(String[] args) {
		new TrollHunt().start();
	}
}
