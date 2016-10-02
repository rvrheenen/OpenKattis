import java.io.*;
import java.util.*;

public class Pripreme {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

        int count = io.nextInt();
        long sum = 0;
        long max = 0;

        for (int i = 0; i < count; i++) {
            int elem = io.nextInt();
            sum += elem;
            if (max < elem)
                max = elem;
        }

        if (max > sum - max) {
            System.out.println(max * 2);
        } else {
            System.out.println(sum);
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