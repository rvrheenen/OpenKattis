import java.io.*;
import java.util.*;

/**
 * Problem: given a list of dominos that knock each other over, 
 * give how many dominos need to be manually knocked over
 * in order to knock all dominos over.
 * NB: run with -Xss32m
 *
 * Proposed solution: count the weakly connected components
 * This gives the wrong answer though.
 */

public class Dominos {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		int nCases = io.nextInt();
		int nDominoes, nRelations, nKnocked, from, to;
		for (int c = 0; c < nCases; c++) {
			nDominoes  = io.nextInt();
			nRelations = io.nextInt();

			N[] dominoes = new N[nDominoes];
			for (int i = 0; i < nDominoes; i++) {
				dominoes[i] = new N();
			}

			E[] relations = new E[nRelations];
			for (int i = 0; i < nRelations; i++) {
				from = io.nextInt() - 1;
				to = io.nextInt() - 1;
				dominoes[from].adjacents.add(dominoes[to]);
				dominoes[to].adjacents.add(dominoes[from]);
			}

			int counter = 0;
			for (int i = 0 ; i < nDominoes; i++) {
				if (!dominoes[i].active) continue;
				counter++;
				dominoes[i].knockOver();
			}

			System.out.println(counter);
		}	
		
		io.close();
	}

	static class N {
		boolean active;
		ArrayList<N> adjacents;

		N() {
			active = true;
			adjacents = new ArrayList<N>();
		}

		public void knockOver() {
			if (active) {
				active = false;
				for (N dom : adjacents) {
					dom.knockOver();
				}
			}
		}
	}

	static class E {
		N start, end;

		E(N start, N end) {
			this.start = start;
			this.end = end;
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
