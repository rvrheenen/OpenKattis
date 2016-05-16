import java.io.*;
import java.util.Scanner;

public class JuryJeopardy {

	int dir = 0;
	public int curX, curY, maxX, maxY, minY = 0;

	PrintStream out = new PrintStream(System.out);
	Scanner in = new Scanner(System.in);

	void start() {
		int testCases = in.nextInt();
		out.println(testCases);
		for (int i = 0; i < testCases; i++) {
			testCases(in);
		}
	}

	void testCases(Scanner in){		
		String string = in.next();
		
		int lengte = string.length();
		int[] xRow = new int[lengte];
		int[] yRow = new int[lengte];
		
		for(int i = 0; i<lengte; i++) {
			int absDir = richting(string.charAt(i));
//			dirRow[i] = absDir;
			
			if(absDir == 2){
				curX--;
			} else if(absDir == 0){
				curX++;
				if(maxX<curX){
					maxX++;
				}	
			} else if(absDir== 1){
				curY--;
				if(minY>curY){
					minY--;
				}
			} else {
				curY++;
				if(curY>maxY){
					maxY++;
				}
			}
			
			xRow[i] = curX;
			yRow[i] = curY;
		}
		
		int newY = maxY-minY;
		int posY = -minY;
		
		boolean[][] matrix = new boolean[newY+2][maxX+1];
		int newX = maxX+2;
		out.println(newY+3 + " " + newX);
		
		for(int i=0; i<lengte;i++){
			matrix[yRow[i]+posY][xRow[i]] = true;
		}
		for(int h=0; h<maxX+1; h++){
			out.printf("#");
		}
		out.printf("#\n");
		for(int i=0; i<newY+2; i++){
			for(int j=0; j<maxX+1; j++){
				if(matrix[i][j]==true){
					out.printf(".");
				} else out.printf("#");
			}
			out.printf("#\n");
		}
		
		dir = 0;
		curX = 0;
		curY =0;
		maxX =0;
		maxY =0;
		minY = 0;
	}

	int richting(char c) {

		if (c == 'F') {
			return dir;
		} else if (c == 'L') {
			dir++;
			dir = dir % 4;
			return dir;
		} else if (c == 'R') {
			dir += 3;
			dir = dir % 4;
			return dir;
		} else {
			dir += 2;
			dir = dir % 4;
			return dir;
		}
	}

	public static void main(String[] args) {
		new JuryJeopardy().start();
	}
}
