import java.io.*;
import java.util.*;
import java.lang.Math;

public class HumanCannonBall2 {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		int nCases = io.nextInt();

		double time, height, velocity, angle, distanceToWall, lowerEdge, upperEdge;

		for (int i = 0; i < nCases; i++) {
			velocity 	   = io.nextDouble();
			angle 	  	   = Math.toRadians(io.nextDouble());
			distanceToWall = io.nextDouble();
			lowerEdge      = io.nextDouble();
			upperEdge 	   = io.nextDouble();

			time = distanceToWall / (velocity * Math.cos(angle));
			height = (velocity * time * Math.sin(angle)) - (0.5 * 9.81 * time * time);

			io.println((height > (lowerEdge + 1) && height < (upperEdge - 1)) ? "Safe" : "Not Safe");

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
