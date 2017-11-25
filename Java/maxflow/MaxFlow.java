import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

// Got the flow, still need to extract path
public class MaxFlow {
	// Dinics max flow
	// O(V^2 * E)
	static class Edge {
		int end, rev, cap, flow;

		public Edge(int t, int rev, int cap) {
			this.end = t;
			this.rev = rev;
			this.cap = cap;
		}
	}

	public static ArrayList<ArrayList<Edge>> createGraph(int nodes) {
		ArrayList<ArrayList<Edge>> graph = new ArrayList<ArrayList<Edge>>(nodes);
		for (int i = 0; i < nodes; i++) {
			graph.add(new ArrayList<Edge>());
		}
		return graph;
	}

	public static void addEdge(ArrayList<ArrayList<Edge>> graph, int s, int t, int cap) {
		graph.get(s).add(new Edge(t, graph.get(t).size(), cap));
		graph.get(t).add(new Edge(s, graph.get(s).size() - 1, 0));
	}

	static boolean dinicBfs(ArrayList<ArrayList<Edge>> graph, int src, int dest, int[] dist) {
		Arrays.fill(dist, -1);
		dist[src] = 0;
		int[] Q = new int[graph.size()];
		int sizeQ = 0;
		Q[sizeQ++] = src;
		for (int i = 0; i < sizeQ; i++) {
			int u = Q[i];
			for (Edge e : graph.get(u)) {
				if (dist[e.end] < 0 && e.flow < e.cap) {
					dist[e.end] = dist[u] + 1;
					Q[sizeQ++] = e.end;
				}
			}
		}
		return dist[dest] >= 0;
	}

	static int dinicDfs(ArrayList<ArrayList<Edge>> graph, int[] ptr, int[] dist, int dest, int u, int f) {
		if (u == dest)
			return f;
		for (; ptr[u] < graph.get(u).size(); ++ptr[u]) {
			Edge e = graph.get(u).get(ptr[u]);
			if (dist[e.end] == dist[u] + 1 && e.flow < e.cap) {
				int df = dinicDfs(graph, ptr, dist, dest, e.end, Math.min(f, e.cap - e.flow));
				if (df > 0) {
					e.flow += df;
					graph.get(e.end).get(e.rev).flow -= df;
					// System.out.printf("%d %d %d <== %d && %d %d %b\n", e.rev, e.end, e.flow, df, f, e.cap - e.flow, (f < e.cap - e.flow));
					return df;
				}
			}
		}
		return 0;
	}

	public static int maxFlow(ArrayList<ArrayList<Edge>> graph, int src, int dest) {
		int flow = 0;
		int[] dist = new int[graph.size()];
		while (dinicBfs(graph, src, dest, dist)) {
			int[] ptr = new int[graph.size()];
			while (true) {
				int df = dinicDfs(graph, ptr, dist, dest, src, Integer.MAX_VALUE);
				if (df == 0)
					break;
				// System.out.println(df);
				flow += df;
			}
		}
		return flow;
	}

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		int nNodes = io.nextInt();
		int nEdges = io.nextInt();
		int source = io.nextInt();
		int sink = io.nextInt();

		ArrayList<ArrayList<Edge>> graph = createGraph(nNodes);
		int from, end, capacity;
		for (int i = 0; i < nEdges; i++) {
			from = io.nextInt();
			end = io.nextInt();
			capacity = io.nextInt();
			System.out.printf("%d %d %d\n", from, end, capacity);
			addEdge(graph, from, end, capacity);
		}
		System.out.println("======<<");
		printGraph(graph);
		System.out.println("======");
        int flow = maxFlow(graph, source, sink);

        int nEdgesUsed = 0;
        for (ArrayList<Edge> node : graph) {
			for (Edge e : node) {
				if (e.flow > 0){
                    nEdgesUsed++;
					io.printf("%d %d %d\n", Math.min(e.rev, e.end), Math.max(e.rev, e.end), e.flow);
				}
			}
		}
        System.out.printf("%d %d %d\n", nNodes, flow, nEdgesUsed);
        io.close();
	}

	public static void printGraph(ArrayList<ArrayList<Edge>> graph) {
		for (ArrayList<Edge> edges : graph) {
			for (Edge e : edges) {
				System.out.printf("%d %d %d\n", e.rev, e.end, e.cap);
			}
		}
	}

	public static void printGraphSol(ArrayList<ArrayList<Edge>> graph) {
		for (ArrayList<Edge> node : graph) {
			for (Edge e : node) {
				if (e.flow > 0){
					System.out.printf("%d %d %d\n", Math.min(e.rev, e.end), Math.max(e.rev, e.end), e.flow);
				}
			}
		}
	}

	// Class in only for testing.
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
