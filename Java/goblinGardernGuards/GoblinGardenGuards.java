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
            int[][] gCoords = new int[G][2];
            for (int i = 0; i < G; i++){
                inp = bi.readLine().split(" ");
                gCoords[i][0] = Integer.parseInt(inp[0]); 
                gCoords[i][1] = Integer.parseInt(inp[1]); 
            }

            int S = Integer.parseInt(bi.readLine());
            int[][] sCoords = new int[S][3];
            for (int i = 0; i < S; i++){
                inp = bi.readLine().split(" ");
                sCoords[i][0] = Integer.parseInt(inp[0]); 
                sCoords[i][1] = Integer.parseInt(inp[1]); 
                sCoords[i][2] = Integer.parseInt(inp[2]); 
            }
            // END INPUT

            int goblinsLeft = G;

            for (int g = 0; g < G; g++){ // for every goblin
                for (int s = 0; s < S; s++){ // for every sprinkler
                    if (canGetWet(gCoords[g], sCoords[s])){
                        goblinsLeft--;
                        break;
                    }
                }
                if (goblinsLeft == 0) break;
            }
            System.out.println(goblinsLeft);

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static boolean canGetWet(int[] g, int[] s){
        return (Math.sqrt(Math.pow(Math.abs(g[0]-s[0]),2) + Math.pow(Math.abs(g[1]-s[1]),2)) <= s[2]);
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
