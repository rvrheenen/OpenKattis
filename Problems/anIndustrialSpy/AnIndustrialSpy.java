package anIndustrialSpy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class AnIndustrialSpy {

	BufferedReader br;
	PrintStream out;

	AnIndustrialSpy(){
		out = new PrintStream(System.out);
		br  = new BufferedReader(new InputStreamReader(System.in));
	}

	void start(){
		try {
			int C = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < C; i++) {			
				out.printf("%d", numberOfPrimes(br.readLine()));
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	int numberOfPrimes(String input ){
		//
		
		return Integer.parseInt(input); //PLACEHOLDER
	}

	public static void main(String[] args) {
		new AnIndustrialSpy().start();
	
	}
}
