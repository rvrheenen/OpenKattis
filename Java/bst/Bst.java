import java.io.*;
import java.util.*;
import java.lang.Math;

public class Bst {
	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		TreeMap<Integer, Integer> depths = new TreeMap<Integer, Integer>();
		Integer node, largestSmaller, smallestLarger, depth;
		long totalDepth = 0;

		int nNodes = io.nextInt();
		
		for (int i = 0; i < nNodes; i++) {
			node = io.nextInt();
			largestSmaller = depths.floorKey(node);
			smallestLarger = depths.ceilingKey(node);

			if (largestSmaller == null) {
				if (smallestLarger == null) {
					depth = 0;
				} else {
					depth = depths.get(smallestLarger) + 1;
				}
			} else if (smallestLarger == null){
				depth = depths.get(largestSmaller) + 1;
			} else {
				depth = Math.max(depths.get(largestSmaller), depths.get(smallestLarger)) + 1;
			}
			depths.put(node, depth);
			totalDepth += depth;
			io.println(totalDepth);
		}


		/* // The too slow solution, which builds an actual binary tree and adds all the (max 300k) nodes:
		int nNodes = io.nextInt();
		BinaryTree tree = new BinaryTree();

		for (int i = 0; i < nNodes; i++) {
			io.println(tree.insert(io.nextInt()));
		}
		*/
		io.close();
	}

	static class BinaryTree {
		Node root;
		int counter;
		
		public BinaryTree()	{
			this.root = null;
			this.counter = 0;
		}

		// insert n in tree, return value of counter (int)
		public int insert(int n) {
			Node newNode = new Node(n);

			if(this.root == null){
				this.root = newNode;
				return this.counter;
			}

			Node current = this.root;
			Node parent = null;
			while(true){
				parent = current;
				this.counter += 1;
				if(n < current.data) {				
					current = current.left;
					if(current == null) {
						parent.left = newNode;
						return this.counter;
					}
				} else {
					current = current.right;
					if(current == null) {
						parent.right = newNode;
						return this.counter;
					}
				}
			}
		}
	}

	static class Node {
		int data;
		Node left, right;
		
		public Node(int data) {
			this.data  = data;
			this.left  = null;
			this.right = null;
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