package boundingRobots;

//Input
/*
3 3
1
u 1
4 5
2
u 3
r 4
10 10
4
r 30
d 30
l 25
u 5
0 0
 
 */


import java.io.PrintStream;
import java.util.Scanner;

public class BoundingRobots {

	PrintStream out;
	Scanner in;

	BoundingRobots() {
		out = new PrintStream(System.out);
		in = new Scanner(System.in);
	}

	void start() {
		boolean check = true;
		while (check) {
			int roboX = 0;
			int roboY = 0;
			int actualX = 0;
			int actualY = 0;

			int roomX = in.nextInt();
			int roomY = in.nextInt();

			if (roomX == 0 && roomY == 0) {
				check = false;
			} else {
				roomX -= 1;
				roomY -= 1;

				int N = in.nextInt();
				for (int i = 0; i < N; i++) {
					String dir = in.next();
					int steps = in.nextInt();
					if (dir.equals("l")) {// if left{
						roboX -= steps;
						actualX -= steps;
						actualX = correct(actualX, roomX);
					} else if (dir.equals("r")) { // if right
						roboX += steps;
						actualX += steps;
						actualX = correct(actualX, roomX);
					} else if (dir.equals("d")) { // if down
						roboY -= steps;
						actualY -= steps;
						actualY = correct(actualY, roomY);
					} else { // if up
						roboY += steps;
						actualY += steps;
						actualY = correct(actualY, roomY);
					}
				}
				out.printf("Robot thinks %d %d\n", roboX, roboY);
				out.printf("Actually at %d %d\n", actualX, actualY);
				out.print("\n");
			}
		}
	}

	int correct(int coord, int room) {
		coord = (coord < 0) ? 0 : coord;
		coord = (coord > room) ? room : coord;
		return coord;
	}

	public static void main(String[] args) {
		new BoundingRobots().start();
	}
}
