import java.io.*;
import java.util.*;

public class AnotherBrick {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		int height = io.nextInt();
		int width  = io.nextInt();
		int nBricks = io.nextInt();

		int index = 0;
		int layer = 0;
		int brick;
		boolean willComplete = true;

		for (int i = 0; i < nBricks; i++) {
			brick = io.nextInt();
			index += brick;
			if (index > width) {
				willComplete = false;
				break;
			} else if (index == width) {
				index = 0;
				layer++;
				if (layer == height) {
					break;
				}
			}
		}
		io.println(willComplete ? "YES" : "NO");
		
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
