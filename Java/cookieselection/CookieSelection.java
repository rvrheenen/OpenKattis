import java.io.*;
import java.util.*;

// Works, but too slow, like expected
public class CookieSelection {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		List<Integer> cookies = new ArrayList<Integer>();
		String line;
		int cookie;
		
		while ((line = io.nextLine()) != null) {
			if (line.equals("#")) {
				Collections.sort(cookies);
				if (cookies.size() % 2 == 0) {
					cookie = (cookies.size() / 2);
				} else {
					cookie = ((cookies.size()) / 2);
				}
				io.println(cookies.get(cookie));
				cookies.remove(cookie);
			} else {
				cookies.add(Integer.parseInt(line));
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
