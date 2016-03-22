import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Game2048 {

    public static void main(String[] args){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int[][] 	board = new int[4][4];
        String[] 	row;
        int 		dir;

        try {
        	for (int i = 0; i < 4; i++) {
        		row = br.readLine().split(" ");
        		for (int j = 0; j < 4; j++) {
        			board[i][j] = Integer.parseInt(row[j]);
        		}
        	}
        	dir = Integer.parseInt(br.readLine());
        	board = rotateBoard(board, dir);
        	board = shiftBoardLeft(board);
			board = rotateBoard(board, ((4-dir)%4));
			print2DArray(board);        	
        } catch(Exception e){
            e.printStackTrace();
        }
    }
    public static int[][] rotateBoard(int[][] board, int rotations){
    	if (rotations == 0) return board;
    	int[][] newBoard = new int[4][4];
    	for (int i = 0; i < 4; i++) {
    		for (int j = 0; j < 4 ; j++) {
    			if (rotations == 1) {
	    			newBoard[3-j][i] = board[i][j]; // rotates counterclockwise
	    		} else if (rotations == 2){ 
	    			newBoard[3-i][3-j] = board[i][j]; //rotates twice
	    		} else if (rotations == 3){
	    			newBoard[j][3-i] = board[i][j]; // rotates clockwise
	    		}
    		}
    	}
    	return newBoard;
    }

    public static int[][] shiftBoardLeft(int[][] board){
    	for (int i = 0; i < 4; i++){
    		for (int j = 1; j < 4; j++){
    			if (onlyZeroes(board[i], j)){
    				continue;
    			} else if (board[i][j-1] == board[i][j]){
    				board[i][j-1] *= 2;
    			} else if (board[i][j-1] == 0){
    				board[i][j-1] = board[i][j];
    				j--;
    			} else if (board[i][j] != 0){
    				continue;
    			}
    			int j_ = j;
    			if (board[i][j] == 0) j--;
    			for (int k = j_; k < 3; k++){
    				board[i][k] = board[i][k+1];
    			}
    			board[i][3] = 0;
    		}
    	}
    	return board;
    }

    public static boolean onlyZeroes(int[] row, int index){
    	for (int i = index; i < row.length; i++){
    		if (row[i] != 0){
    			return false;
    		}
    	}
    	return true;
    }

    public static void print2DArray(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(Integer.toString(arr[i][j]) + " ");
            }
            System.out.print("\n");
        }
    }
}
