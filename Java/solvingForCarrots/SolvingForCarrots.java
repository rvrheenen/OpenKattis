package solvingForCarrots;

import java.io.PrintStream;
import java.util.Scanner;

public class SolvingForCarrots {
	
	Scanner in;
	PrintStream out;
	
	SolvingForCarrots(){
		out = new PrintStream(System.out);
		in = new Scanner(System.in);
	}
	
	void start() {
		int N = in.nextInt();
		int P = in.nextInt();
		out.printf("%d", P);
	}	

	public static void main(String[] args) {
		new SolvingForCarrots().start();
	}
}