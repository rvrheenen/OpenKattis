import java.io.*;
import java.util.*;

public class Vauvau {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);
		int[][] dogs = {{io.nextInt(), io.nextInt()}, {io.nextInt(), io.nextInt()}};
		int[] visits = {io.nextInt(), io.nextInt(), io.nextInt()};

		boolean[] aggression = {false, false};
		for (int i = 0; i < visits.length ; i++) { // For each visit
			for (int j = 0 ; j < dogs.length; j++) { // For each dog
				aggression[j] = ( (visits[i] - 1 % (dogs[j][0] + dogs[j][1])) < dogs[j][0]); // Is current moment in aggressive period?
			}
			if (aggression[0] && aggression[1]) {
				System.out.println("both");
			} else if (aggression[0] || aggression[1]) {
				System.out.println("one");
			} else {
				System.out.println("none");
			}
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