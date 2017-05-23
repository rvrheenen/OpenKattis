import java.io.*;
import java.util.*;

public class SavingForRetirement {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		int bobAge 	   = io.nextInt();
		int bobRetire  = io.nextInt();
		int bobSaves   = io.nextInt();
		int aliceAge   = io.nextInt();
		int aliceSaves = io.nextInt();

		int bobSaved = (bobRetire - bobAge) * bobSaves;

		int aliceYears = 0;
		while (aliceYears * aliceSaves <= bobSaved) {
			aliceYears++;
		}
		io.print(aliceAge + aliceYears);
		
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
