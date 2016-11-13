import java.io.*;
import java.util.*;

// From BAPC 2016
public class StickySituation {

    public static void main(String[] args) throws IOException {
        IO io = new IO(System.in);
        
        int number = io.nextInt();
        long[] array = new long[number];
        for(int i=0; i < number; i++){
            array[i] = io.nextLong();
        }
        
        boolean found = false;
        Arrays.sort(array);
        for(int i = number - 1; i >= 2; i--) {
            if(array[i] < array[i - 1] + array[i - 2]) {
                io.println("possible");
                found = true;
                break;
            } 
        }
        if(!found){
            io.print("impossible");
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
