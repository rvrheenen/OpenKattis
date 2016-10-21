import java.io.*;
import java.util.*;
import java.lang.*;
public class SnapperHard {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		int n = io.nextInt();
		int snappers;
		int snaps;
		boolean light;
		
		for (int i = 0; i < n; i++) {
			snappers = io.nextInt();
			snaps = io.nextInt();
			if (snappers > 1){
				light = ((snaps % (Math.pow(2, snappers)) == Math.pow(2, snappers) - 1));
			} else {
				light = (snaps %2) != 0;
			}
			io.printf("Case #%d: %s\n", i + 1, (light ? "ON" : "OFF"));
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