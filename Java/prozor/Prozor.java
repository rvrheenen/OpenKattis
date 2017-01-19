import java.io.*;
import java.util.*;

public class Prozor {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		int rows = io.nextInt();
		int columns = io.nextInt();
		int racket = io.nextInt();

		char[][] window = new char[rows][columns];
		String line;
		for (int r = 0; r < rows; r++) {
			line = io.next();
			for (int c = 0; c < columns; c++) {
				window[r][c] = line.charAt(c);
			}
		}

		int bestHit = 0;
		int bestHitCornerR = 0;
		int bestHitCornerC = 0;
		int hit;
		for (int r = 0; r < rows - racket + 1; r++) {
			for (int c = 0; c < columns - racket + 1; c++) {
				
				hit = 0;
				for (int i = r + 1; i < r + racket - 1; i++) {
					for (int j = c + 1; j < c + racket - 1; j++) {
						if (window[i][j] == '*') {
							hit ++;
						}
					}
				}
				if (hit > bestHit) {
					bestHit = hit;
					bestHitCornerR = r;
					bestHitCornerC = c;
				}
			}
		}

		window[bestHitCornerR][bestHitCornerC] = '+';
		window[bestHitCornerR + racket - 1][bestHitCornerC] = '+';
		window[bestHitCornerR + racket - 1][bestHitCornerC + racket - 1] = '+';
		window[bestHitCornerR][bestHitCornerC + racket - 1] = '+';
		
		for (int i = bestHitCornerC + 1; i < bestHitCornerC + racket - 1; i++) {
			window[bestHitCornerR][i] = '-';
		}
		for (int i = bestHitCornerR + 1; i < bestHitCornerR + racket - 1; i++) {
			window[i][bestHitCornerC] = '|';
		}
		for (int i = bestHitCornerC + 1; i < bestHitCornerC + racket - 1; i++) {
			window[bestHitCornerR + racket - 1][i] = '-';
		}
		for (int i = bestHitCornerR + 1; i < bestHitCornerR + racket - 1; i++) {
			window[i][bestHitCornerC + racket - 1] = '|';
		}
		io.println(bestHit);
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < columns; c++) {
				io.printf("%c", window[r][c]);
			}
			io.println();
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
