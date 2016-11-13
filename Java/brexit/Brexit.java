import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// From BAPC 2016
public class Brexit {
	static class V implements Comparable<V> {
		public final int name;
		public List<E> adj;
		public double dist = Double.POSITIVE_INFINITY;
		public V prev;
		public int edgeNum = 0;
		public int curNum = 0;
		public boolean destoryed = false;
		
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
		public final double w;
		
		public E(V _e, double _w){
			end = _e;
			w = _w;
		}
	}

	static void compute(IO io, V[] vertices, int firstToLeave, int self){
		V toLeave = vertices[firstToLeave];
		toLeave.destoryed = true;
		if(toLeave.name == self){
			terminate(io, "leave");
		}
		for(int i = 0; i < vertices[firstToLeave].adj.size(); i++){
			V endpoint = vertices[firstToLeave].adj.get(i).end;
			if(!endpoint.destoryed) endpoint.curNum--;
			if(endpoint.edgeNum == 1 && !endpoint.destoryed){
				destroy(io, vertices,endpoint, self);
			}else if(endpoint.edgeNum / endpoint.curNum >= 2 && !endpoint.destoryed){
				destroy(io, vertices, endpoint, self);
			}
		}
		terminate(io, "stay");
	}
	
	static void destroy(IO io, V[] vertices, V destroy, int self){
		if(destroy.name == self){
			terminate(io, "leave");
		}
		destroy.destoryed = true;
		for(int i=0; i<destroy.adj.size(); i++){
			V endpoint = vertices[destroy.name].adj.get(i).end;
			if(!endpoint.destoryed) endpoint.curNum--;
			if(endpoint.edgeNum == 1 && !endpoint.destoryed){
				destroy(io, vertices,endpoint, self);
			} else if(endpoint.edgeNum / endpoint.curNum >= 2 && !endpoint.destoryed){
				destroy(io, vertices, endpoint, self);
			}
		}		
	}
	
	static void terminate(IO io, String toPrint) {
		io.println(toPrint);
		io.close();
		System.exit(0);	
	}
	
	public static void main(String args[]) throws IOException{
		IO io = new IO(System.in);
		
		int countries = io.nextInt();
		int relations = io.nextInt();
		int self = io.nextInt() - 1;
		int firstToLeave = io.nextInt() - 1;
		
		V[] vertices = new V[countries];
		E[] edges    = new E[2 * relations];
		
		for(int i = 0; i < countries; i++){
			vertices[i] = new V(i);
		}
		
		for(int i = 0; i < relations; i++){
			int start = io.nextInt();
			int end   = io.nextInt();
			double w = 1;
			edges[2 * i] = new E(vertices[end - 1], w);
			edges[2 * i + 1] = new E(vertices[start - 1], w);
			vertices[start - 1].adj.add(edges[2 * i]);
			vertices[end - 1].adj.add(edges[2 * i + 1]);
		}
		
		for(int i = 0; i < countries; i++){
			vertices[i].edgeNum = vertices[i].adj.size();
			vertices[i].curNum = vertices[i].adj.size();
		}
		
		compute(io, vertices, firstToLeave, self);
		io.close();
	}
	
	static class IO extends PrintWriter{
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
		
		public int nextInt() throws IOException{
			return Integer.parseInt(next());
		}
		public long nextLong() throws IOException{
			return Long.parseLong(next());
		}
		public double nextDouble() throws IOException{
			return Double.parseDouble(next());
		}
	}
}