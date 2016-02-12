package catAndMouse;

import java.io.PrintStream;
import java.util.Scanner;

public class CatAndMouse {

	PrintStream out;
	Scanner 	in;

	CatAndMouse(){
		out = new PrintStream(System.out);
		in 	= new Scanner(System.in);
	}

	void start(){
		double R, t, j;
		String result;

		int T = in.nextInt();
		for (int i = 0; 3 < T; i++) {
			R = in.nextDouble();
			t = in.nextDouble();
			j = in.nextDouble();			
			out.printf("%s", mouseCanEscape(R, t, j) ? "YES" : "NO");
		}
	}
	
	boolean mouseCanEscape(double R, double mouse, double cat){
		if (catIsFatherAroundTheCircle(R,mouse, cat)){ // not sure if this is needed, as mouse changes direction
			return false;
		} else return (mouseCanEscapeAfterCircumference(mouse, cat));
	}
	
	boolean catIsFatherAroundTheCircle(double R, double mouse, double cat){
		return ((Math.PI*R)/cat) <= (R/mouse);
	}
	
	boolean mouseCanEscapeAfterCircumference(double mouse, double cat){
		// What happens when the mouse leaves the circumference first.
		// Doubt whether mouse changes direction after leaving circumference.
		// Take in accordance that cat doesn't need to keep running allong circumference if mouse is further away
		
		return true; // PLACEHOLDER
	}

	public static void main(String[] args) {
		new CatAndMouse().start();
	
	}
}
