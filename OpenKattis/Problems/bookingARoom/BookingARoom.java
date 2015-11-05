package bookingARoom;
/*
 * 
100 5
42
3
2
99
1
 
 
3 3
2
3
1
 
 */

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

  public class BookingARoom{

	Scanner in;
	PrintStream out;

	BookingARoom() {
		out = new PrintStream(System.out);
		in = new Scanner(System.in);
	}

	void start() {
		int total = in.nextInt();
		int full = in.nextInt();
		int[] rooms = new int[full];
		for (int i = 0; i < full; i++) {
			rooms[i] = in.nextInt();
		}

		if (total != full) {
			if (full != 0) {
				Arrays.sort(rooms);
				for (int i = 0; i <= rooms.length; i++) {
					if (rooms[i] == full) {
						out.println(i + 2);
						break;
					} else {
						if (rooms[i] != i + 1) {
							out.println(i + 1);
							break;
						}
					}
				}
			} else {
				out.print("1");
			}
		} else {
			out.println("too late");
		}
	}

	void printAr(int[] ar) {
		for (int i = 0; i < ar.length; i++) {
			out.printf("%d ", ar[i]);
		}
		out.println();
	}

	public static void main(String[] args) {
		new BookingARoom().start();
	}
}
