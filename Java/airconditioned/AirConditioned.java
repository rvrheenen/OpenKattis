import java.io.*;
import java.util.*;

public class AirConditioned {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		int nMinions = io.nextInt();

		Minion[] minions = new Minion[nMinions];
		for (int i = 0; i < nMinions; i++) {
			minions[i] = new Minion(io.nextInt(), io.nextInt());
		}

		Arrays.sort(minions, new Comparator<Minion>() {
			@Override
			public int compare(Minion m1, Minion m2) {
				if (m1.upper < m2.upper) {
					return -1;
				} else {
					return 1;
				}
			}
		});

		int rooms = 1;
		int threshold = minions[0].upper;
		for (int i = 1 ; i < nMinions; i++) {
			if (minions[i].lower > threshold) {
				rooms++;
				threshold = minions[i].upper;
			}
		}
		io.println(rooms);
		
		io.close();
	}

	static class Minion {
		int lower, upper;

		Minion(int l, int u) {
			this.lower = l;
			this.upper = u;
		}
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
