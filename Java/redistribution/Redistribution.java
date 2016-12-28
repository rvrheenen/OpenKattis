import java.io.*;
import java.util.*;

public class Redistribution {

	public static void main(String[] args) throws IOException {
		IO io = new IO(System.in);

		int numberOfRooms = io.nextInt();
		Room[] rooms = new Room[numberOfRooms];

		for (int i = 0; i < numberOfRooms; i++) {
			rooms[i] = new Room(i + 1, io.nextInt());
		}

		Arrays.sort(rooms, new Comparator<Room>(){

			@Override
			public int compare(Room arg0, Room arg1) {
				return -1 * (new Integer(arg0.numberOfExams).compareTo(new Integer(arg1.numberOfExams)));
			}
		});

		int totalExams = 0;
		for (int i = 0; i < numberOfRooms; i++) {
			totalExams += rooms[i].numberOfExams;
		}

		if (totalExams - rooms[0].numberOfExams < rooms[0].numberOfExams) {
			io.println("impossible");
		} else {
			for (int i = 0; i < numberOfRooms; i++) {
				io.printf("%d%s", rooms[i].roomNumber, i < numberOfRooms - 1 ? " " : "");
			}
			io.println();
		}


		
		io.close();
	}

	static class Room {
		int roomNumber;
		int numberOfExams;

		Room(int r, int e) {
			this.roomNumber = r;
			this.numberOfExams = e;
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
