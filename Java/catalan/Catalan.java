import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Catalan {

	public static BigInteger[] factorials = new BigInteger[10001];
	public static int highestFactorial = 1;

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		int nQueries = io.nextInt();

		// Calculates the nth catalan number using C(n) = (2n)! / ((n + 1)! n!)
		factorials[0] = BigInteger.ONE;
		factorials[1] = BigInteger.ONE;
		for (int i = 0; i < nQueries; i++) {
			io.println(catalan(io.nextInt()));
		}

		// Calculates the nth catalan number using the Binomial Coefficient:
		// for (int i = 0; i < nQueries; i++) {
		// 	io.println(catalanBC(io.nextInt()));
		// }


		// Calculates the nth catalan number using DP:

		// BigInteger[] catalans = new BigInteger[5000];
		// catalans[0] = BigInteger.ONE;
		// catalans[1] = BigInteger.ONE;

		// int query;
		// int highest = 1;
		// for (int i = 0; i < nQueries; i++) {
		// 	query = io.nextInt();
		// 	if (query > highest) {
		// 		for (int j = highest + 1; j < query + 1; j++) {
		// 			catalans[j] = BigInteger.valueOf(0);
		// 			for (int k = 0; k < j; k++) {
		// 				catalans[j] = catalans[j].add(catalans[k].multiply(catalans[j - k - 1]));
		// 			}
		// 		}
		// 		highest = query;
		// 	}
		// 	io.println(catalans[query]);
		// }
		
		io.close();
	}

	/**
	 * Calculates the nth catalan number using C(n) = (2n)! / ((n + 1)! n!)
	 */
	public static BigInteger catalan(int n) {
		return factorial(2 * n).divide(factorial(n + 1).multiply(factorial(n)));
	}

	public static BigInteger factorial(int n) {
		if (n <= highestFactorial) {
			return factorials[n];
		}
		for (int i = highestFactorial + 1; i <= n; i++) {
			factorials[i] = factorials[i - 1].multiply(BigInteger.valueOf(i));
		}
		highestFactorial = n;
		return factorials[n];
	}

	/**
	 * Calculates the nth catalang number using the Binomial Coefficient:
	 * C(n) = 2nCn / n + 1
	 */
	public static BigInteger catalanBC(int n) {
		return binomialCoefficient(2 * n, n).divide( BigInteger.valueOf(n + 1) );
	}

	public static BigInteger binomialCoefficient(int n, int k) {
	    BigInteger result = BigInteger.valueOf(1);
	 
	    if (k > n - k){
	        k = n - k;
	    }

	    for (int i = 0; i < k; ++i) {
	        result = result.multiply(BigInteger.valueOf(n - i));
	        result = result.divide(BigInteger.valueOf(i + 1));
	    }

	    return result;
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
