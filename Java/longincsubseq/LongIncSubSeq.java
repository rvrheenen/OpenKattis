import java.io.*;
import java.util.*;

public class LongIncSubSeq {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		int nElements, len, highest, left, right, middle, alen;
		int[] tIndexes;
		int[] pIndexes;
		int[] answer;

		while(true) {
			try {
				nElements = io.nextInt();
			} catch(Exception e) {
				break;
			}

			int[] elements = new int[nElements];
			tIndexes = new int[nElements];
			pIndexes = new int[nElements];
			for (int i = 0; i < nElements; i++) {
				elements[i] = io.nextInt();
				tIndexes[i] = 0;
				pIndexes[i] = -1;
			}

			len = 1;
			for (int i = 1; i < nElements; i++) {
				if (elements[i] <= elements[tIndexes[0]]) {
					tIndexes[0] = i;
				} else if (elements[i] > elements[tIndexes[len - 1]]) {
					pIndexes[i] = tIndexes[len - 1];
					tIndexes[len++] = i;
				} else {
				 	left = -1;
				 	right = len - 1;
				 	while (right - left > 1) {
				 		middle = left + (right - left) / 2;
				 		if (elements[tIndexes[middle]] >= elements[i]) {
				 			right = middle;
				 		} else {
				 			left = middle;
				 		}
				 	}
			 		pIndexes[i] = tIndexes[right - 1];
			 		tIndexes[right] = i;
				}
			}
			
		    io.println(len);
			answer = new int[len];
			alen = 0;
			for (int i = tIndexes[len - 1]; i >= 0; i = pIndexes[i]) {
				answer[alen++] = i;
			}

			for(int i = 0; i < answer.length; i++) {
				io.printf("%d ", answer[answer.length - i - 1]);
			}
			io.println();
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
