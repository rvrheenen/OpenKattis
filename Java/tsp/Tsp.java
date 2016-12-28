import java.io.*;
import java.util.*;
import java.lang.Math;

public class Tsp {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);
		
		int nCities = io.nextInt();

		City[] cities = new City[nCities];

		for (int i = 0; i < nCities; i++) {
			cities[i] = new City(io.nextDouble(), io.nextDouble());
		}

		int[] solution = greedyTour(cities);

		for (int i = 0 ; i < solution.length; i++) {
			io.println(solution[i]);
		}
		
		io.close();
	}

	public static int[] greedyTour(City[] cities) {
		int[] tour = new int[cities.length];
		boolean[] used = new boolean[cities.length];

		tour[0] = 0;
		used[0] = true;
		int best;
		for (int i = 1; i < cities.length; i++) {
			best = -1;
			for (int j = 0; j < cities.length; j++) {
				if (!used[j] && (best == -1 || dist(cities[tour[i - 1]], cities[j]) < dist(cities[tour[i - 1]], cities[best]) ) ) {
					best = j;
				}
			}
			tour[i] = best;
			used[best] = true;
		}
		return tour;
	}

	public static double dist(City c1, City c2) {
		return Math.sqrt( Math.pow((c1.x - c2.x), 2) + Math.pow((c1.y - c2.y), 2) );
	}

	static class City {
		double x, y;

		City(double x, double y) {
			this.x = x;
			this.y = y;
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
