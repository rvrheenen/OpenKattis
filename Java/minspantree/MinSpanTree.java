import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MinSpanTree { // doesn't work, but it really should..

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);
		int sum;

		while(true) {

			int nV = io.nextInt();
			int nE = io.nextInt();
			if (nV == 0) {
				break;
			}
			V[] vertices = new V[nV];
			E[] edges = new E[nE];

			for (int j = 0; j < nV; j++) {
				vertices[j] = new V(j);
			}
			for (int j = 0; j < nE; j++) {
				int start = io.nextInt();
				int end = io.nextInt();
				double w = io.nextDouble();
				if (end > start) {
                    edges[j] = new E(vertices[start], vertices[end], w);
                } else {
                    edges[j] = new E(vertices[end], vertices[start], w);
                }
			}

			ArrayList<E> result = compute(nV, edges);
			if (result.size() > 0) {
				sum = 0;
				for (int i = 0; i < result.size() ; i++) {
					sum += result.get(i).w;
				}
				io.println(sum);

                Collections.sort(result, new Comparator<E>() {
                    @Override
                    public int compare(E e1, E e2) {
                        if (e1.start.name == e2.start.name) {
                            return Integer.compare(e1.end.name, e2.end.name);
                        } else {
                            return Integer.compare(e1.start.name, e2.start.name);
                        }
                    }
                });

                for (int i = 0; i < result.size(); i++) {
					io.printf("%d %d\n", result.get(i).start.name, result.get(i).end.name);
				}

			} else {
				io.println("Impossible");
			}
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

	// Given number of vertices nV and E[] edges,
	// returns a list of edges that form a minimum spanning tree.
	// O(E log E).
	static ArrayList<E> compute(int nV, E[] edges) {
		ArrayList<E> res = new ArrayList<E>();
		UnionFind uni = new UnionFind(nV);
		PriorityQueue<E> q = new PriorityQueue<E>();
		for (int i = 0; i < edges.length; i++) {
			q.add(edges[i]);
		}

		while (!q.isEmpty()) {
			E e = q.poll();
			int start = e.start.name;
			int end = e.end.name;
			if (uni.find(start) != uni.find(end)) {
				uni.union(start, end);
				res.add(e);
			}
		}
		return res;
	}

	static class V {
		public final int name;
		public List<E> adj;

		public V(int nm) {
			name = nm;
			adj = new ArrayList<E>();
		}
	}

	static class E implements Comparable<E>{
		public final double w;
		public final V end;
		public final V start;

		public E(V argStart, V argEnd, double argW) {
			start = argStart;
			end = argEnd;
			w = argW;
		}

		public int compareTo(E other) {
			return Double.compare(this.w, other.w);
		}
	}

	static class UnionFind {
		private int[] parent;
		private int[] rank;
		public int nSets;

		public UnionFind(int size) {
			parent = new int[size];
			rank = new int[size];
			nSets = size;
			for (int i = 0; i < parent.length; i++) {
				parent[i] = i;
			}
		}

		public void union(int x, int y) {
			int xRoot = find(x);
			int yRoot = find(y);

			if (xRoot == yRoot) {
				return;
			}

			if (rank[xRoot] < rank[yRoot]) {
				parent[xRoot] = yRoot;
			} else if (rank[xRoot] > rank[yRoot]) {
				parent[yRoot] = xRoot;
			} else {
				parent[yRoot] = xRoot;
				rank[xRoot]++;
			}
			nSets--;
		}

		public int find(int x) {
			if (parent[x] != x) {
				parent[x] = find(parent[x]);
			}
			return parent[x];
		}
	}
}
