import java.io.*;
import java.util.*;
import java.lang.*;
import java.lang.StringBuffer;

public class Yoda {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		String[] input = {io.next(), io.next()};
		String[] output = {"",""};

		input[0] = leadingZeros(input[0], Math.max(input[0].length(), input[1].length()));
		input[1] = leadingZeros(input[1], Math.max(input[0].length(), input[1].length()));
		
		for (int i = 0; i <  Math.max(input[0].length(), input[1].length()); i++) {
			if ( getXToLastCharValue(input[0], i) > getXToLastCharValue(input[1], i) ) {
				output[0] = new StringBuffer(output[0]).insert(0, input[0].charAt(input[1].length() - i - 1)).toString();
			} else if ( getXToLastCharValue(input[0], i) < getXToLastCharValue(input[1], i) ) {
				output[1] = new StringBuffer(output[1]).insert(0, input[1].charAt(input[1].length() - i - 1)).toString();
			} else {
				output[0] = new StringBuffer(output[0]).insert(0, input[0].charAt(input[1].length() - i - 1)).toString();
				output[1] = new StringBuffer(output[1]).insert(0, input[1].charAt(input[1].length() - i - 1)).toString();
			}
		}

		for (int i = 0 ; i < 2; i++  ) {
			if (output[i].length() == 0) {
				output[i] = "YODA";
			} else if (Integer.parseInt(output[i]) == 0) {
				output[i] = "0";
			}
			io.println(output[i]);
		}

		
		io.close();
	}
	
	public static String leadingZeros(String s, int length) {
	    if (s.length() >= length) return s;
	    else return String.format("%0" + (length-s.length()) + "d%s", 0, s);
	}

	public static int getXToLastCharValue(String str, int x) {
		return Character.getNumericValue(str.charAt(str.length() - x - 1)); 
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
