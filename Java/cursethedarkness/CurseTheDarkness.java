import java.io.*;
import java.util.*;
import java.lang.Math;

public class CurseTheDarkness {

	static final int LIGHT_REACH = 8;

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		int nCases = io.nextInt();

		double bookX, bookY, candleX, candleY;
		int nCandles;
		boolean lit;
		while (nCases --> 0) {
			bookX = io.nextDouble();
			bookY = io.nextDouble();
			nCandles = io.nextInt();
			lit = false;
			while (nCandles --> 0) {
				candleX = io.nextDouble();
				candleY = io.nextDouble();
				if (!lit && ((Math.abs(bookX - candleX) * Math.abs(bookX - candleX)) + (Math.abs(bookY - candleY) * Math.abs(bookY - candleY)) <= (LIGHT_REACH * LIGHT_REACH)) ) {
					lit = true;
				}
			}
			io.println(lit ? "light a candle" : "curse the darkness");
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

        public String nextLine() throws IOException {
            return r.readLine();
        }

		public String next() throws IOException {
			while (!t.hasMoreTokens()) {
				t = new StringTokenizer(nextLine());
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
