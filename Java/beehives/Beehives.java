import java.io.*;
import java.util.*;

public class Beehives {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);
		double distance;
		int hives;

		int[] sours;
		int sour;
		
		while(true) {
			distance = io.nextDouble();
			hives = io.nextInt();
			double[][] bees;

			if (distance + hives == 0) break;

			// get input
			bees = new double[hives][2];
			for (int i = 0 ; i < hives; i++) {
				bees[i][0] = io.nextDouble();
				bees[i][1] = io.nextDouble();
			}

			//check which are in range of another hive
			sours = new int[hives];
			for (int i = 0 ; i < hives; i++) {
				if (sours[i] > 0) continue;
				for (int j = 0 ; j < hives; j++) {
					if (i == j) continue;
					if (isInRange(bees[i][0], bees[i][1], bees[j][0], bees[j][1], distance)) {
						sours[i]++;
						sours[j]++;
					}
				}
			}
			
			// count sweet and sours
			sour = 0;
			for (int i = 0 ; i < hives; i++) {
				if (sours[i] > 0) sour++;
			}
			io.printf("%d sour, %d sweet\n", sour, hives-sour);

		}
		
		io.close();
	}

	static boolean isInRange(double x1, double y1, double x2, double y2, double distance) {
		return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) < distance * distance;
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
