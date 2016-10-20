// Still too slow!
import java.io.*;
import java.util.*;

public class AutomaticTrading {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);
		char[] trades = io.next().toCharArray();
		int queries = io.nextInt();

		int[] points = new int[2];
		for (int i = 0; i < queries; i++) {
			points[0] = io.nextInt();
			points[1] = io.nextInt();
			int seq = 0;
			while (((points[0] + seq) < trades.length) && ((points[1] + seq) < trades.length) ) {
				if (trades[points[0] + seq] == trades[points[1] + seq]) {
					seq++;
				} else {
					break;
				}
			}
			System.out.println(seq);
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