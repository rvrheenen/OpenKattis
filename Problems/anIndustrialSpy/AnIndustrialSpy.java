package anIndustrialSpy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashSet;

public class AnIndustrialSpy {

	PrintStream    out;
	BufferedReader br;
	

	AnIndustrialSpy(){
		out = new PrintStream(System.out);
		br  = new BufferedReader(new InputStreamReader(System.in));
	}

	void start(){
		try {
			int C = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < C; i++) {
				HashSet<Double> primes = makeCombinations("", br.readLine(), new HashSet<Double>());
				out.println(primes.size());
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	HashSet<Double> makeCombinations(String str1, String str2, HashSet<Double> primes){
		if (str1 != "") if (isPrime(Double.parseDouble(str1))) primes.add(Double.parseDouble(str1)); 
		for (int i = 0; i < str2.length();i++){
			makeCombinations(str1+str2.substring(i, i+1), popFromString(str2, i), primes);
		}
		return primes;
	}
	
	String popFromString(String str, int i){ // returns string without the character at place i
		return (str.length() >  i) ? str.substring(0, i) + str.substring(i+1) : str.substring(0, i);
	}
	
	boolean isPrime(double num) { // Returns true if prime number
		if (num == 2) {
			return true;
		} else if (num % 2 == 0) {
			return false;
		} else if (num == 1) {
			return false;
		}
		double sqrt = Math.sqrt(num);
		for (double i = 3; i <= (sqrt); i+=2) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		new AnIndustrialSpy().start();
	
	}
}
