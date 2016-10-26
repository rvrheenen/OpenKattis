import java.io.*;
import java.util.*;

public class Guess {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		int number = 500;
		int lower_bound = 1;
		int upper_bound = 1001;
		String response;
		
		while(true) {
			System.out.println(number);
			response = io.next();
			if (response.equals("correct")) {
				break;
			}
			if (response.equals("lower")) {
				upper_bound = number;
			} else if (response.equals("higher")) {
				lower_bound = number;
			}
			number = (int)((lower_bound + upper_bound) / 2);
		}
		
		io.close();
	}

	static class IO extends PrintWriter {
		static BufferedReader r;
		static StringTokenizer t;

		public IO(InputStream i) {
			super(new BufferedOutputStream(System.out));
			r = new BufferedReader(new InputStreamReader(i));
			t = new StringTokenizer("");
		}

		public String next() throws IOException {
			while (!t.hasMoreTokens()) {
				t = new StringTokenizer(r.readLine());
			}
			return t.nextToken();
		}

		public int nextInt() throws IOException{
			return Integer.parseInt(next());
		}

		public long nextLong() throws IOException {
			return Long.parseLong(next());
		}

		public double nextDouble() throws IOException {
			return Double.parseDouble(next());
		}
	}
}