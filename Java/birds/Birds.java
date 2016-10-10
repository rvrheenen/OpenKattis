import java.io.*;
import java.util.*;

public class Birds {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

        int lineLength = io.nextInt();
        int distanceBetweenBirds = io.nextInt();
        int initialBirdsAmount = io.nextInt();	

        int[] initialBirds = new int[initialBirdsAmount];
        for(int i = 0; i < initialBirdsAmount; i++){
            initialBirds[i] = io.nextInt();
        }
        Arrays.sort(initialBirds);

        int linePointer = 6;
        int counter = 0;
        for (int i = 0; i < initialBirdsAmount; i++) {
        	while(true) {
        		if (initialBirds[i] - linePointer >= distanceBetweenBirds) {
        			linePointer += distanceBetweenBirds;
        			counter++;
        		} else {
        			linePointer = initialBirds[i] + distanceBetweenBirds;
        			break;
        		}
        	}
        }
     
        while(linePointer <= lineLength - 6){
            counter++; linePointer += distanceBetweenBirds;
        }

		System.out.println(counter);
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