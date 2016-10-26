import java.io.*;
import java.util.*;

public class RockPaperScissors {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);
		int nPlayers, nGames, p1, p2;
		String p1move, p2move;
		boolean first_run = true;

		while(true){
		    nPlayers = io.nextInt();
		    if (nPlayers == 0) {
		        break;
		    }
		    if (first_run) {
		        first_run = false;
		    } else {
		    	System.out.printf("\n");
		    }
			nGames = io.nextInt();
		    int[] resultsW = new int[nPlayers];
		    int[] resultsL = new int[nPlayers];
		    for (int i = 0; i < ( ((nGames*nPlayers)*(nPlayers - 1)) / 2 ) ; i++) {
		    	p1 = io.nextInt();
		    	p1move = io.next();
		    	p2 = io.nextInt();
		    	p2move = io.next();
		        if (p1move.equals(p2move)){
		            continue;
		        }
		        if ((p1move.equals("scissors") && p2move.equals("paper")) || (p1move.equals("paper") && p2move.equals("rock")) || (p1move.equals("rock") && p2move.equals("scissors"))) {
		            resultsW[p1 - 1]++;
		            resultsL[p2 - 1]++;
		        } else {
		            resultsW[p2 - 1]++;
		            resultsL[p1 - 1]++;
		        }
		    } 
		    for (int i = 0; i < nPlayers; i++) {
		        double w_plus_l = resultsL[i] + resultsW[i];
		        if  (w_plus_l == 0){
		            System.out.println("-");
		        } else {
		            System.out.printf("%.3f\n", (resultsW[i] / w_plus_l));
		        }
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