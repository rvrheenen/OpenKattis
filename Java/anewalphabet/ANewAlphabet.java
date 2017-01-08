import java.io.*;
import java.util.*;

public class ANewAlphabet {

	static HashMap<Character, String> translations;

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);
		initializeTranslations();

		String line = io.nextLine();
		for (int i = 0 ; i < line.length(); i++) {
			io.printf("%s", translations.get(Character.toLowerCase(line.charAt(i))) != null ? translations.get(Character.toLowerCase(line.charAt(i))) : line.charAt(i) );
		}
		io.println();
		
		io.close();
	}

	public static void initializeTranslations() {
		translations = new HashMap<Character, String>();
		translations.put('a', "@");
		translations.put('b', "8");
		translations.put('c', "(");
		translations.put('d', "|)");
		translations.put('e', "3");
		translations.put('f', "#");
		translations.put('g', "6");
		translations.put('h', "[-]");
		translations.put('i', "|");
		translations.put('j', "_|");
		translations.put('k', "|<");
		translations.put('l', "1");
		translations.put('m', "[]\\/[]");
		translations.put('n', "[]\\[]");
		translations.put('o', "0");
		translations.put('p', "|D");
		translations.put('q', "(,)");
		translations.put('r', "|Z");
		translations.put('s', "$");
		translations.put('t', "']['");
		translations.put('u', "|_|");
		translations.put('v', "\\/");
		translations.put('w', "\\/\\/");
		translations.put('x', "}{");
		translations.put('y', "`/");
		translations.put('z', "2");
		translations.put(' ', " ");
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
