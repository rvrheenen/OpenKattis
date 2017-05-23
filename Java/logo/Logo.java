import java.io.*;
import java.util.*;

public class Logo {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		int nCases = io.nextInt();

		double x, y;
		int amount, degrees, nActions;
		String action;
		while ( nCases --> 0) {
			nActions = io.nextInt();
			x = y = 0.0;
			degrees = 0;
			while (nActions --> 0) {
				action = io.next();
				amount = io.nextInt();
				switch(action) {
					case "lt":
						degrees = degrees - amount;
						if (degrees < 0) degrees += 360;
						break;
					case "rt":
						degrees = degrees + amount;
						if (degrees >= 360) degrees -= 360;
						break;
					case "fd":
						io.printf("[>>%.2f, %.2f]\n", Math.cos(degrees) * amount, Math.sin(degrees) * amount); // << something is going wrong with the degrees
						x += Math.cos(degrees) * amount;
						y += Math.sin(degrees) * amount;
						break;
					case "bk":
						x -= Math.cos(degrees) * amount;
						y -= Math.sin(degrees) * amount;
						break;
				}
				io.printf("==>%.2f %.2f (%d)\n", x, y, degrees);	
			}
			io.printf("%.2f %.2f\n", x, y);
			io.println( Math.sqrt((Math.abs(x) * Math.abs(x)) + (Math.abs(y) * Math.abs(y))) );
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
