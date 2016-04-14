import java.util.Random;

public class GenerateBoard {
	public static String[][] board = new String[8][8];
	public static void main(String[] args){

		for (int i = 0; i < 8 ; i ++){
    		for (int j = 0; j < 8; j++){
    			board[i][j] = ".";
    		}
    	}
    	int x, y;
    	int i = 0;
    	Random rnd = new Random();
    	while (i < 8){
    		x = rnd.nextInt(8);
    		y = rnd.nextInt(8);
    		if (board[x][y].equals(".")){
    			board[x][y] = "*";
    			i++;
    		}
    	}
    	print2DArray(board);

	}

	public static void print2DArray(String[][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.print("\n");
        }
    }
}