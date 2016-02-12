package pet;

import java.io.PrintStream;
import java.util.Scanner;

public class Pet {
	
	Scanner in;
	PrintStream out;
	
	Pet(){
		out = new PrintStream(System.out);
		in = new Scanner(System.in);
	}
	
	void start() {
		int highestPlace = 0;
		int highestScore = 0;
		int counter = 1;
		while (counter<6){
			Scanner line = new Scanner(in.nextLine()).useDelimiter(" ");
			int score = 0;
			while (line.hasNext()){
				score += line.nextInt();
			}
			if (score > highestScore){
				highestScore = score;
				highestPlace = counter;
			}
		counter++;
		}
		out.printf("%d %d", highestPlace, highestScore);
	}

	public static void main(String[] args) {
		new Pet().start();
	}
}