import java.io.*;
import java.util.*;

public class BigTruck {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

    int numLocations = io.nextInt();
    V[] nodes = new V[numLocations];
    for (int i = 0; i < numLocations; i++) {
      nodes[i] = new V(i, io.nextInt());
    }

    int numRoads = io.nextInt();
    int from, to, weight;
    for (int i = 0; i < numRoads; i++) {
      from = io.nextInt() - 1;
      to = io.nextInt() - 1;
      weight = io.nextInt();
      nodes[from].adj.add(new E(nodes[to], weight));
      nodes[to].adj.add(new E(nodes[from], weight));
    }

    compute(nodes[numLocations-1]);

    if (nodes[0].dist == Double.POSITIVE_INFINITY) {
      io.println("impossible");
    } else {
      io.printf("%.0f %d\n", nodes[0].dist, nodes[0].val);
    }

		io.close();
	}

  static class V implements Comparable<V> {
    public final int name;
    public List<E> adj;
    public int w;
    public double dist = Double.POSITIVE_INFINITY;
    public int val = 0;
    public V prev;

    public V(int _n, int _w) {
      name = _n;
      adj = new ArrayList<E>();
      w = _w;
    }

    public int compareTo(V o) {
      return Double.compare(dist, o.dist);
    }
  }

  static class E {
    public final V end;
    public final double w;

    public E(V _e, double _w) {
      end = _e;
      w = _w;
    }
  }

  static void compute(V source) {
    source.dist = 0.;
    source.val = source.w;

    PriorityQueue<V> q = new PriorityQueue<>();
    q.add(source);

    while (!q.isEmpty()) {
      V v = q.poll();
      for (E e : v.adj) {
        V u = e.end;
        double uDist = v.dist + e.w;
        int uVal = v.val + u.w;
        if (uDist < u.dist || (uDist == u.dist && uVal > u.val)) {
          q.remove(u);
          u.dist = uDist;
          u.val = uVal;
          u.prev = v;
          q.add(u);
        }
      }
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
