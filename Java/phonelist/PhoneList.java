import java.io.*;
import java.util.*;

public class PhoneList {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);
		
		int nNumbers;
		int cases = io.nextInt();
		boolean consistent;
		
		for (int i = 0; i < cases ; i++) {
			nNumbers = io.nextInt();
			String[] phonenumbers = new String[nNumbers];
			
			for (int j = 0; j < nNumbers; j++) {
				phonenumbers[j] = io.next();
			}
			Arrays.sort(phonenumbers);

			consistent = true;
			for (int j = 0; j < phonenumbers.length - 1; j++) {
				if (phonenumbers[j+1].startsWith(phonenumbers[j])) {
					consistent = false;
					break;
				}
			}
			io.printf("%s\n", (consistent) ? "YES" : "NO" );
		}
		
		io.close();
	}

	static void printArray(String[] array) {
        for (String f: array) {
            System.out.printf("%s \n", f);
        }
        System.out.printf("\n");
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