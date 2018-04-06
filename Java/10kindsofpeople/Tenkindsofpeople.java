import java.io.*;
import java.util.*;

public class Tenkindsofpeople {

	private static final int[][] DIRECTIONS = {	{0,-1}, {1,0}, {0,1}, {-1,0} };

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		int rows = io.nextInt();
		int cols = io.nextInt();

		char[][] map = new char[rows][cols];
		String line;
		for (int r = 0; r < rows; r++) {
			map[r] = io.next().toCharArray();
		}
		// printMap(map);
		// System.out.println();

		int[][] groupedMap = groupMap(map);
		// printMap(groupedMap);

		int nQueries = io.nextInt();
		for (int i = 0 ; i < nQueries; i++) {
			Coordinate from = new Coordinate( io.nextInt() - 1, io.nextInt() - 1 );
			Coordinate to 	= new Coordinate( io.nextInt() - 1, io.nextInt() - 1 );

			if (groupedMap[from.r][from.c] == groupedMap[to.r][to.c] ) {
				System.out.println( map[from.r][from.c] == '0' ? "binary" : "decimal" );
			} else {
				System.out.println("neither");
			}
		}

		io.close();
	}

	public static int[][] groupMap(char[][] map) {
		int[][] grouped = new int[map.length][map[0].length];

		Queue<Coordinate> q = new LinkedList<Coordinate>();
		char currentType = '0';
		int currentGroup = 2;

		for (int r = 0 ; r < map.length; r++) {
			for (int c = 0 ; c < map[0].length; c++) {
				if (grouped[r][c] > 1) {
					continue;
				}
				currentType = map[r][c];
				grouped[r][c] = currentGroup;
				q.add(new Coordinate(r, c));
				while(!q.isEmpty()) {
					Coordinate curr = q.poll();

					for (int i = 0 ; i < DIRECTIONS.length; i++) {
						int newCoordR = curr.r + DIRECTIONS[i][0];
						int newCoordC = curr.c + DIRECTIONS[i][1];

						if (newCoordR >= 0 && newCoordR < map.length && newCoordC >= 0 && newCoordC < map[0].length) {
							if (grouped[newCoordR][newCoordC] < 2 && map[newCoordR][newCoordC] == currentType) {
								grouped[newCoordR][newCoordC] = currentGroup;
								q.add(new Coordinate(newCoordR, newCoordC));
							}
						}
					}
				}
				currentGroup++;
			}
		}

		return grouped;
	}

	public static void printMap(int[][] map) {
		for (int i =0 ; i < map.length; i++) {
			for (int j = 0 ; j < map[0].length; j++) {
				System.out.printf(String.format("%d", map[i][j]) + " ");
			}
			System.out.println();
		}
	}

	public static void printMap(char[][] map) {
		for (int i =0 ; i < map.length; i++) {
			for (int j = 0 ; j < map[0].length; j++) {
				System.out.printf(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static class Coordinate {
		public int r, c;

		Coordinate(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public boolean equals(Object o) {
			if (o == this) {
				return true;
			}
			if (o instanceof Coordinate ){
				Coordinate coord = (Coordinate) o;
				if (coord.r == this.r && coord.c == this.c) {
					return true;
				}
			}
			return false;
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
