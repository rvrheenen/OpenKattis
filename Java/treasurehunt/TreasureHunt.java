import java.io.*;
import java.util.*;

public class TreasureHunt {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		int rows = io.nextInt();
		int columns = io.nextInt();
		char[][] map = new char[rows][columns];
		boolean[][] visited = new boolean[rows][columns];

		String line;
		for (int r = 0; r < rows; r++) {
			line = io.nextLine();
			for (int c = 0; c < columns; c++) {
				map[r][c] = line.charAt(c);
			}
		}
		
		int steps = 0;
		int r = 0, c = 0;
		visited[0][0] = true;

		while(true) {
			if (map[r][c] == 'N'){
				r--;
			} else if(map[r][c] == 'S') {
				r++;
			} else if(map[r][c] == 'W') {
				c--;
			} else if(map[r][c] == 'E') {
				c++;
			} else if(map[r][c] == 'T') {
				io.println(steps);
				break;
			}

			if (r < 0 || r >= rows || c < 0 || c >= columns) {
				io.println("Out");
				break;
			}
			if ( visited[r][c] ) {
				io.println("Lost");
				break;
			}
			steps++;
			visited[r][c] = true;
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
