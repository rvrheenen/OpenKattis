import java.io.*;
import java.util.*;

// Works great, but is way too slow on bigger data sets
// Should look into union find

public class VirtualFriends {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		int nCases = io.nextInt();

		Map<String, Set<String>> people = new HashMap<>();
		int nFriendships;
		String n1, n2;

		Set<String> visited = new HashSet<>();
		Queue<String> q = new LinkedList<String>();
		
		while(nCases --> 0) {
			people.clear();
			nFriendships = io.nextInt();
			while(nFriendships --> 0) {
				n1 = io.next();
				n2 = io.next();
				if (people.get(n1) == null) {
					people.put(n1, new HashSet<>() );
				}
				if (people.get(n2) == null) {
					people.put(n2, new HashSet<>() );
				}
				people.get(n1).add(n2);
				people.get(n2).add(n1);
				
				visited.clear();
				q.clear();
				q.add(n1);
				int counter = 0;
				while(!q.isEmpty()) {
					for (String friend : people.get(q.poll())) {
						if (!visited.contains(friend)) {
							visited.add(friend);
							counter++;
							q.add(friend);
						}
					}
				}
				io.println(counter);
				// HashSet<String> out = new HashSet<String>(people.get(n1));
				// for(String f: people.get(n1)) {
				// 	out.addAll(people.get(f));
				// }
				// io.println(out.size());
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