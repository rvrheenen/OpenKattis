import java.io.*;
import java.util.*;

public class Detour {

	static V[] vertices;
	static E[] edges;
	static boolean stop = false;
	static ArrayList<Integer> found;

	static class V implements Comparable<V>{
		public final int name;
		public List<E> adj;
		public double dist = Double.POSITIVE_INFINITY;
		public V prev;

		public V(int _n){
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
		public final double w;

		public E(V _e, double _w){
			end = _e;
			w = _w;
		}
	}

	static void compute(V source){
		source.dist = 0.;
		PriorityQueue<V> q = new PriorityQueue<>();
		q.add(source);

		while(!q.isEmpty()){
			V v = q.poll();
			for(E e : v.adj){
				V u = e.end;
				double uDist = v.dist + e.w;
				if(uDist < u.dist){
					q.remove(u);
					u.dist = uDist;
					u.prev = v;
					q.add(u);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		IO io = new IO(System.in);

		int nV = io.nextInt();
		int nE = io.nextInt();

		vertices = new V[nV];
		edges = new E[nE*2];

		for(int i=0; i<nV; i++){
			vertices[i] = new V(i);
		}

		for(int i = 0; i< nE; i++){
			int start = io.nextInt();
			int end = io.nextInt();
			double w = io.nextDouble();

			edges[2*i] = new E(vertices[end], w);
			edges[2*i+1] = new E(vertices[start], w);

			vertices[start].adj.add(edges[2*i]);
			vertices[end].adj.add(edges[2*i+1]);
		}

		compute(vertices[1]);

		for(int i=0; i<nV; i++){
			if(i==1){
				continue;
			}
			for(int j=vertices[i].adj.size()-1; j>=0; j--){
				if(vertices[i].adj.get(j).end.name == vertices[i].prev.name){
					//io.printf("%d removes %d\n",vertices[i].name, vertices[i].adj.get(j).end.name);
					int from = vertices[i].name;
					int to = vertices[i].adj.get(j).end.name;
					//vertices[i].adj.remove(j);
					for(int f=0; f<vertices[to].adj.size(); f++){
						if(vertices[to].adj.get(f).end.name == from){
							//io.printf("%d removes %d\n",vertices[to].name, vertices[to].adj.get(f).end.name);
							vertices[to].adj.remove(f);
						}
					}
				}
			}
		}

		for(int i=0; i<nV; i++){
			vertices[i].dist = Double.POSITIVE_INFINITY;
			vertices[i].prev = null;
		}

		compute(vertices[1]);

		//for(int i=0; i<nV; i++){
		//	io.println(vertices[i].dist);
		//}

		int x = 0;
		ArrayList<Integer> path = new ArrayList<Integer>();
		if(vertices[x].prev == null){
			io.printf("impossible");
		} else {
			while(vertices[x].name != 1){
				path.add(vertices[x].name);
				x = vertices[x].prev.name;
			}
			path.add(1);

			io.printf("%d", path.size());
			for(int i=0; i<path.size(); i++){
				io.printf(" %d", path.get(i));
			}
		}
		io.printf("\n");


		io.close();
	}



	static class IO extends PrintWriter {
		static BufferedReader r;
		static StringTokenizer t;

		public IO(InputStream i){
			super(new BufferedOutputStream(System.out));
			r = new BufferedReader(new InputStreamReader(i));
			t = new StringTokenizer("");
		}

		public String next() throws IOException{
			while(!t.hasMoreTokens()){
				t = new StringTokenizer(r.readLine());
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
