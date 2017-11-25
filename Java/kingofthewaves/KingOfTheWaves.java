import java.io.*;
import java.util.*;

public class KingOfTheWaves {

    public static V[] participants;
    public static ArrayList<Integer> visited;

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

        int nParticipants = io.nextInt();

        participants = new V[nParticipants];
        visited = new ArrayList<Integer>();

        for (int i = 0; i < nParticipants; i++) {
            participants[i] = new V(i);
        }

        String line;
        for (int i = 0; i < nParticipants; i++) {
            line = io.nextLine();
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) == '1') {
                    participants[i].adj.add(new E(participants[j]));
                }
            }
        }

        traverse(participants[0]);

        if (visited.size() < nParticipants) {
            io.println("impossible");
        } else {
            for (int i = 0 ; i < visited.size(); i++) {
                io.printf("%d ", visited.get(visited.size() - i - 1));
            }
            io.println();
        }


		io.close();
	}

    public static void traverse(V root) {
        if (root.visited) {
            return;
        }
        root.visited = true;
        visited.add(root.name);

        for (E e : root.adj) {
            traverse(e.end);
        }

    }

    static class V implements Comparable<V> {
        public final int name;
        public List<E> adj;
        public boolean visited = false;

        public V(int _n){
            name = _n;
            adj = new ArrayList<E>();
        }

        public int compareTo(V o) {
            return 0;
        }
    }

    static class E{
        public final V end;

        public E(V _e){
            end = _e;
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
