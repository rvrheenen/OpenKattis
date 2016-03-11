// ===============================================
// WORKS LIKE A CHARM, BUT OPEN.KATTIS DISAGREES..
// ===============================================

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EightQueens {

	public static 		int curX, curY, nextX, nextY;
	public static final int[][] DIRECTIONS = {	{0,-1},
												{1,-1},
												{1,0},
												{1,1},
												{0,1},
												{-1,1},
												{-1,0},
												{-1,-1}};

    public static void main(String[] args){

        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        String[][] board = new String[8][8];

        try {
        	for (int i = 0 ; i < 8; i++){
        		String line = bi.readLine();
        		board[i] = line.split("(?!^)");
        	}
        	System.out.println(checkQueens(board) ? "valid" : "invalid");
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static boolean checkQueens(String[][] board){
    	for (int i = 0; i < 8 ; i ++){
    		for (int j = 0; j < 8; j++){
    			if (board[i][j].equals("*")){
    				if (findConflict(board, i, j)){
    					return false;
    				}
    			}
    		}
    	}
    	return true;
    }

    public static boolean findConflict(String[][] board, int x, int y){
    	for (int d = 0; d < 8; d++){
    		curX = x;
    		curY = y;
    		while (true){
    			nextX = curX + DIRECTIONS[d][0]; 
    			nextY = curY + DIRECTIONS[d][1];
    			if (isOnBoard(nextX,nextY)){
    				curX = nextX;
    				curY = nextY;
    				if (board[curX][curY].equals("*")){
    					return true;
    				}
    			} else {
    				break;
    			}
    		} 
    	}
    	return false;
    }

    public static boolean isOnBoard(int x, int y){
    	return (x >= 0 && x < 8 && y >= 0 && y < 8);
    }
}
