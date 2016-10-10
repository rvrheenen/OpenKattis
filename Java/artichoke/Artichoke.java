import java.io.*;
import java.util.*;

public class Artichoke {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		Scanner sc = new Scanner(System.in);
        int p = io.nextInt();
        int a = io.nextInt();
        int b = io.nextInt();
        int c = io.nextInt();
        int d = io.nextInt();
        int n = io.nextInt();
        double max = 0; 
        double maxD = 0;
        for(int k = 1; k <= n; k++){
            double temp = p * (Math.sin((double) a * k + b) + Math.cos((double) c * k + d) + 2);
            if(temp > max){
                max = temp;  
            } else if(max - temp > maxD) {
                maxD = max - temp;
            }
        }
        if(maxD <0) maxD = 0;
        System.out.printf("%.08f\n", maxD);
		
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