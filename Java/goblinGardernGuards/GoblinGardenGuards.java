//WORKS BUT NOT FAST ENOUGH YET
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class GoblinGardenGuards {

     public static void main(String[] args) {

        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            // START INPUT
            String[] inp;        

            int G = Integer.parseInt(bi.readLine());
            int[][] gCoords = new int[G][];
            for (int i = 0; i < G; i++){
                inp = bi.readLine().split(" ");
                gCoords[i] = new int[] { Integer.parseInt(inp[0]), Integer.parseInt(inp[1])}; 
            }

            int S = Integer.parseInt(bi.readLine());
            int[][] sCoords = new int[S][];
            for (int i = 0; i < S; i++){
                inp = bi.readLine().split(" ");
                sCoords[i] = new int[] { Integer.parseInt(inp[0]), Integer.parseInt(inp[1]), Integer.parseInt(inp[2]) }; 
            }
            // END INPUT

            int goblinsLeft = G;

            for (int g = 0; g < G; g++){ // for every goblin
                for (int s = 0; s < S; s++){ // for every sprinkler
                    int x = gCoords[g][0] - sCoords[s][0];
                    int y = gCoords[g][1] - sCoords[s][1];
                    if (x*x+y*y <= sCoords[s][2]*sCoords[s][2]) {
                        goblinsLeft--;
                        break;
                    }
                }
            }
            System.out.println(goblinsLeft);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void print2DArray(int[][] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
