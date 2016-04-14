import java.util.ArrayList;

/**
 * Created by martinpettersson on 08/11/15.
 */
public class SecondOpinion {
    Kattio io = new Kattio(System.in);

    public static void main(String[] args) {
        new SecondOpinion();
    }

    public SecondOpinion() {
        String[] chessGrid = handleInput();

        if (countQueens(chessGrid) != 8) {
            System.out.println("invalid");
            return;
        }

        if (testRows(chessGrid)) {
            if (testDiagonals(chessGrid))
                System.out.println("valid");
            else System.out.println("invalid");
        } else System.out.println("invalid");
        io.close();
    }

    private int countQueens(String[] grid) {
        int numberOfQueens = 0;
        for (String row : grid)
            numberOfQueens += row.length() - row.replace("*", "").length();
        return numberOfQueens;
    }

    private boolean testRows(String[] grid) {
        for (String word : grid) {
            int countQueens = word.length() - word.replace("*", "").length();
            if (countQueens > 1)
                return false;
        }

        grid = transpose(grid);

        for (String word : grid) {
            int countQueens = word.length() - word.replace("*", "").length();
            if (countQueens > 1)
                return false;
        }

        return true;
    }

    private boolean testDiagonals(String[] grid) {
        for (int i = 0; i < 4; i++) {
            ArrayList<String> diagonals = diagonals(grid);
            for (String word : diagonals) {
                int countQueens = word.length() - word.replace("*", "").length();
                if (countQueens > 1)
                    return false;
            }
            grid = transpose(grid);
        }

        return true;
    }

    private ArrayList<String> diagonals(String[] chessGrid) {
        ArrayList<String> diagonals = new ArrayList<String>();
        for (int row = 0; row < chessGrid.length; row++) {
            StringBuffer buffer = new StringBuffer();
            for (int index = 0; index < chessGrid.length && index + row < chessGrid[0].length(); index++) {
                buffer.append(chessGrid[index].charAt(index + row));
            }
            diagonals.add(buffer.toString());
        }
        return diagonals;
    }

    private String[] transpose(String[] chessGrid) {
        String[] transposedGrid = new String[chessGrid.length];
        for (int i = 0; i < chessGrid.length; i++) {
            String word = "";
            for (int j = 0; j < chessGrid.length; j++) {
                word += chessGrid[j].charAt(i);
            }
            transposedGrid[transposedGrid.length - i - 1] = word;
        }
        return transposedGrid;
    }

    private String[] handleInput() {
        String[] chessGrid = new String[8];
        for (int row = 0; row < chessGrid.length; row++) {
            chessGrid[row] = io.getWord();
        }
        return chessGrid;
    }

}