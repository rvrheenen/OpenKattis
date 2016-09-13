import java.io.*;
import java.util.*;
import java.math.*;

public class Nine {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);
    	BigInteger eight = BigInteger.valueOf(8);
    	BigInteger nine = BigInteger.valueOf(9);
    	BigInteger mod = BigInteger.valueOf(1000000007);
    	BigInteger ans;

    	int N = io.nextInt();

    	for (int i = 0; i < N ; i++) {
    		BigInteger exp = BigInteger.valueOf(io.nextLong() - 1);
    		ans = eight.multiply(nine.modPow(exp, BigInteger.valueOf(1000000007))).mod(mod);
    		System.out.println(ans);
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