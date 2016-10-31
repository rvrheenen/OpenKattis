// This is the wrong approach, need to look at distances between the stores
import java.io.*;
import java.util.*;
import java.lang.Math;

public class Kastenlauf {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);
        int nStores;
        double distToTarget;
        
        int cases = io.nextInt();
        boolean happy;
        for (int c = 0; c < cases; c++) {

            nStores = io.nextInt();
            
            int[] home = {io.nextInt(), io.nextInt()};
            double[] distances = new double[nStores + 2 /*include destination*/]; 
            distances[0] = 0;
            for (int i = 1; i < nStores + 2/*include destination*/; i++) {
                distances[i] = getDistance(home[0], home[1], io.nextInt(), io.nextInt());
            }
            distToTarget = distances[nStores+1];
            Arrays.sort(distances);
            happy = true;
            for (int i = 1; i < distances.length; i++) {
                if (distances[i] >= distToTarget) {
                    break;
                }
                if ((distances[i] - distances[i - 1]) > 1000) {
                    happy = false;
                    break;
                }
            }
            io.printf("%s\n", happy ? "happy" : "sad");

        }
		
		io.close();
	}

    public static double getDistance(int x1, int y1, int x2, int y2) { // Get Manhattan-distance
        return (Math.abs(x2 - x1) + Math.abs(y2 - y1));
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