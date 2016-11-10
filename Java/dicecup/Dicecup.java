import java.io.*;
import java.util.*;

public class Dicecup {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		int d1 = io.nextInt();
		int d2 = io.nextInt();
		if (d1 <= d2) {
			for (int i = d1 + 1; i <= d2 + 1; i++) {
				io.println(i);
			}
		} else {
			for (int i = d2 + 1; i <= d1 + 1; i++) {
				io.println(i);
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

	}
}