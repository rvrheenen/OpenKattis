import java.io.*;
import java.util.*;

public class AmsterdamDistance{
	public static void main(String[] args) throws IOException{
		IO io = new IO(System.in);

		double pieParts = io.nextDouble();
		double canals = io.nextDouble();
		double radius = io.nextDouble();
		double pieA = io.nextDouble();
		double canalA = io.nextDouble();
		double pieB = io.nextDouble();
		double canalB = io.nextDouble();

		double canalDif = Math.abs(canalA - canalB);
		double canalLength = radius/canals * canalDif;

		double curCanal = Math.min(canalA, canalB);

		double curCircleRadius = radius/canals * curCanal;

		double piePiece = Math.abs(pieA-pieB)/pieParts;

		double pieDist = piePiece*curCircleRadius*Math.PI;

		double result = pieDist + canalLength;

		io.println(Math.min(canalA*radius/canals + canalB*radius/canals, result));

		io.close();
	}

	static class IO extends PrintWriter {
		static BufferedReader r;
		static StringTokenizer t;

		public IO(InputStream i){
			super(new BufferedOutputStream(System.out));
			r = new BufferedReader(new InputStreamReader(i));
			t = new StringTokenizer("");
		}

		public String next() throws IOException{
			while(!t.hasMoreTokens()){
				t = new StringTokenizer(r.readLine());
			}
			return t.nextToken();
		}

		public int nextInt() throws IOException {
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
