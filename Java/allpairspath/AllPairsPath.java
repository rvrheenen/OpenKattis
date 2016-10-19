import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AllPairsPath {

    public static final int INF = 1000000;

    public static void main(String[] args) {
        
        IO io = new IO(System.in);
        boolean firstRun = true;
        int nodes, edges, queries, tmp_x, tmp_y;
        long dist;

        try {
            while(true) {
                nodes = io.nextInt();
                edges = io.nextInt();
                queries = io.nextInt();

                // check for quiting input
                if (nodes == 0 && edges == 0 && queries == 0) {
                    break;
                }

                // enter after every problem
                if (firstRun) {
                    firstRun = false;
                } else {
                    System.out.println();
                }
                
                // Create empty graph and fill it with arbitrary high numbers
                long[][] graph = new long[nodes][nodes];
                for (int i = 0; i < nodes; i++) {
                    Arrays.fill(graph[i], INF);
                }
                
                // enter edges into graph
                for (int i = 0; i < edges; i++) {
                    tmp_x = io.nextInt();
                    tmp_y = io.nextInt();
                    graph[tmp_x][tmp_y] = Math.min(io.nextLong(), graph[tmp_x][tmp_y]);
                }
                
                // map nodes 0 to themselves, done after entering the edges to remove edges that map more than 0 to themselves
                for (int i = 0; i < nodes; i++) {
                    graph[i][i] = 0;
                }
                
                // apply floydWarshall
                long[][] res = floydWarshall(graph);
                
                // Check for negative cycles
                for (int i = 0; i < nodes; i++) {
                    if (res[i][i] < 0) {
                        res[i][i] = -INF; // i is in a negative cycle
                        for (int j = 0; j < nodes; j++) {
                            for (int k = 0; k < nodes; k++) {
                                if (res[j][i] < INF && res[i][k] < INF) {
                                    res[j][k] = -INF; // pairs using i are also negative
                                }
                            }
                        }
                    }
                }
                
                // process queries
                for (int i = 0; i < queries; i++) {
                    dist = res[io.nextInt()][io.nextInt()];
                    if (dist >= INF) {
                        System.out.println("Impossible");                        
                    } else if (dist <= -INF) {
                        System.out.println("-Infinity");
                    } else {
                        System.out.println(dist);
                    }
                }
            }
        
        } catch(IOException e) {
            System.exit(0);
        }

        io.close();
    }
    
    static long[][] floydWarshall(long[][] graph) {
        int nodes = graph.length;
        long dist[][] = graph.clone();

        for (int k = 0; k < nodes; k++) {
            for (int i = 0; i < nodes; i++) {
                for (int j = 0; j < nodes; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF) {
                        if (dist[i][k] + dist[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
        }
        return dist;
    }

    static void printArray(long[][] array) {
        for (long[] e: array) {
            for (long f: e) {
                System.out.printf("%.0f ", f);
            }
            System.out.printf("\n");
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