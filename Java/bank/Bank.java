import java.io.*;
import java.util.*;

// This doesn't work yet, need to finish this up..

public class Bank {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		int nPeople = io.nextInt();
		int timeLeft = io.nextInt();

		Person[] people = new Person[nPeople];

		for (int i = 0; i < nPeople; i++) {
			people[i] = new Person(io.nextInt(), io.nextInt());
		}
		Arrays.sort(people);

		// printPeople(people);

		int peopleLeft = nPeople;
		int i = 0;
		int time = 0;
		int total = 0;
		while (timeLeft-time > 0 && i < nPeople) {
			if (people[i].time >= time) {
				total += people[i].cash;
				time++;
			}
			i++;
		}

		io.println(total);

		io.close();
	}

	public static void printPeople(Person[] people) {
		for (Person person : people) {
			System.out.printf("%d, %d\n", person.cash, person.time);
		}
	}

	static class Person implements Comparable<Person> {
		int cash;
		int time;
		boolean served;

		Person(int c, int t) {
			cash = c;
			time = t;
			served = false;
		}

		@Override
		public int compareTo(Person o) {
			if (this.time - o.time != 0) {
				return this.time - o.time;
			} else {
				return o.cash - this.cash;
			}
		}

		// @Override
		// public String toString() {
		// 	return String.format("(%d,%d)", cash, time);
		// }
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
