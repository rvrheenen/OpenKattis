import java.io.*;
import java.util.*;

public class WhereIsMyInternet {

    public static V[] houses;

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		int nHouses = io.nextInt();
		int nCables = io.nextInt();

        houses = new V[nHouses];

        for (int i = 0 ; i < nHouses; i++) {
            houses[i] = new V(i);
        }

        int house1, house2;
        for (int i = 0 ; i < nCables; i++) {
            house1 = io.nextInt() - 1;
            house2 = io.nextInt() - 1;
            houses[house1].adj.add(houses[house2]);
            houses[house2].adj.add(houses[house1]);
        }

        traceNetwork(houses[0]);

        boolean connected = true;
        for (int i = 0 ; i < nHouses; i++) {
            if (!houses[i].visited) {
                io.println(i+1);
                connected = false;
            }
        }
        if (connected) {
            io.println("Connected");
        }

		io.close();
	}

    public static void traceNetwork(V root) {
        if (root.visited) return;
        root.visited = true;

        for(V v : root.adj) {
            traceNetwork(v);
        }
    }

    static class V implements Comparable<V> {
        public final int name;
        public List<V> adj;
        public boolean visited;

        public int compareTo(V v) {
			return 0;
		}

        public V (int name) {
            this.name = name;
            adj = new ArrayList<V>();
            visited = false;
        }
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
