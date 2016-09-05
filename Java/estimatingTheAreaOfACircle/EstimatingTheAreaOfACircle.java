import java.io.*;
import java.util.*;
import java.math.*;

public class EstimatingTheAreaOfACircle {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		while(true) {
			double r = io.nextDouble();
			int    m = io.nextInt();
			int    c = io.nextInt();
			if (m == 0) {
				break;
			}
			solve(r, m, c);
		}
		
		io.close();
	}

	public static void solve(double r, int m, int c) {
		double area = getArea(r);
		double estimatedArea = (c * 2 * r * 2 * r) / m;
		System.out.println(area + " " + estimatedArea);
	}

	public static double getArea(double radius) {
	    return Math.PI * radius * radius;
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