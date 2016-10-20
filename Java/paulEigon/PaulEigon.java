import java.io.*;
import java.util.*;

public class PaulEigon {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		long serves = io.nextLong();
		long paul_score = io.nextLong();
		long oppo_score = io.nextLong();
		
		if (((paul_score + oppo_score) / serves) % 2 == 0) {
			System.out.println("paul");
		} else{
			System.out.println("opponent");
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