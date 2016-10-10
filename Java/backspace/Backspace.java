import java.io.*;
import java.util.*;

public class Backspace {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

        String line = io.next();
        
        StringBuilder output = new StringBuilder();
        
        for(int i = 0; i < line.length(); i++) {
            if(line.charAt(i) == '<'){
                output.deleteCharAt(output.length() - 1);
            } else {
            	output.append(line.charAt(i));
            }
        }
        System.out.println(output);
		
		
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