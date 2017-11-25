import java.io.*;
import java.util.*;

public class Gold {

    private static final char PLAYER = 'P';
    private static final char GOLD   = 'G';
    private static final char TRAP   = 'T';
    private static final char WALL   = '#';
    private static final char FLOOR  = '.';
    private static final char SEEN   = ',';
    private static final int[][] DIRECTIONS = {	{0,-1}, {1,0}, {0,1}, {-1,0} };

    private static char[][] map;
    private static int goldCount;

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

        int[] playerStart = handleInput(io);
        traverseMap(playerStart[0], playerStart[1]);
        io.println(goldCount);

		io.close();
	}

    static int[] handleInput(IO io) throws IOException {
        int cols = io.nextInt();
        int rows = io.nextInt();

        map = new char[rows][cols];
        int[] playerStart = new int[2];
        String line;
        for (int i = 0; i < rows; i++) {
            line = io.next();
            for (int j = 0; j < cols; j++ ) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == PLAYER) {
                    playerStart = new int[]{i, j};
                }
            }
        }
        return playerStart;
    }

    static void traverseMap(int r, int c) {
        if (coordsOutOfBound(r, c)) return;
        if (map[r][c] == WALL) return;
        if (map[r][c] == SEEN) return;
        if (map[r][c] == GOLD) goldCount++;

        map[r][c] = SEEN;

        if (senseDraft(r, c)) return;

        for (int i = 0; i < DIRECTIONS.length; i++) {
            traverseMap(r + DIRECTIONS[i][0], c + DIRECTIONS[i][1] );
        }
    }

    static boolean coordsOutOfBound(int r, int c) {
        return (r < 0 || r > map.length || c < 0 || c > map[0].length);
    }

    static boolean senseDraft(int r, int c) {
        int rNew, cNew;
        for (int i = 0; i < DIRECTIONS.length; i++) {
            rNew = r + DIRECTIONS[i][0];
            cNew = c + DIRECTIONS[i][1];
            if (coordsOutOfBound(rNew, cNew)) continue;
            if (map[rNew][cNew] == TRAP) return true;
        }
        return false;
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
