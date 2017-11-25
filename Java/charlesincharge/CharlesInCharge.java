import java.io.*;
import java.util.*;

public class CharlesInCharge {
    static IO io;
    static int[] dist;
    static int[] parent;
    static V[] vertices;
    static E[] edges;

    public static void main(String[] args) throws IOException {
        io = new IO(System.in);

        int nVertices     = io.nextInt();
        int nEdges        = io.nextInt();
        double percentage = io.nextDouble();

        vertices = new V[nVertices];
        edges =  new E[nEdges * 2];
        for (int i = 0; i < nVertices; i++) {
            vertices[i] = new V(i);
        }

        for (int i = 0; i < nEdges; i++) {
            int start  = io.nextInt();
            int end    = io.nextInt();
            double weight = io.nextDouble();

            edges[i*2]     = new E(vertices[end - 1], weight);
            edges[(i*2)+1] = new E(vertices[start - 1], weight);

            vertices[start - 1].adj.add(edges[i*2]);
            vertices[end - 1].adj.add(edges[(i*2)+1]);
        }

        compute(vertices[0]);

        double threshold = vertices[vertices.length - 1].dist * ((percentage/100)+1);

        double longest;
        do {
            longest = getLongestEdgeInRoute();

            for (V v : vertices) {
                ListIterator li = v.adj.listIterator();
                while (li.hasNext()){
                    E e = (E) li.next();
                    if (e.w >= longest) li.remove(); // remove edges longer than longest found
                }
            }
            for (V v : vertices) v.dist = Double.POSITIVE_INFINITY;
            compute(vertices[0]);
        } while(vertices[vertices.length - 1].dist < threshold); // continue while feasible route is possible

        io.printf("%.0f", longest);

        io.close();
    }

    static double getLongestEdgeInRoute() {
        V v = vertices[vertices.length - 1];
        double longest = Double.NEGATIVE_INFINITY;
        double dist = v.dist;
        while(v.name != 0) {
            v = v.prev;
            if (dist - v.dist > longest) longest = dist - v.dist;
            dist = v.dist;
        }
        return longest;
    }

    static void compute(V source) {
        source.dist = 0.;
        PriorityQueue<V> q = new PriorityQueue<>();
        q.add(source);
        while (!q.isEmpty()) {
            V v = q.poll();
            for (E e : v.adj) {
                V u = e.end;
                double uDist = v.dist + e.w;
                if (uDist < u.dist) {
                    q.remove(u);
                    u.dist = uDist;
                    u.prev = v;
                    q.add(u);
                }
            }
        }
    }

    static class V implements Comparable<V> {
        public final int name;
        public List<E> adj;
        public double dist = Double.POSITIVE_INFINITY;
        public V prev;
        public V(int _n) {
                name = _n;
                adj = new ArrayList<E>();
        }

        @Override
        public int compareTo(V o) {
            return Double.compare(dist, o.dist);
        }
    }

    static class E {
        public final V end;
        public double w;
        public E(V _e, double _w) {
                end = _e;
                w = _w;
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

        public int nextInt() throws IOException {
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
