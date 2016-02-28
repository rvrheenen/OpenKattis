// DOESN'T WORK AT ALL YET
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;

public class Listgame2 {

     public static void main(String[] args) {

        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            int K = Integer.parseInt(bi.readLine());
            int Y = 0;
            Set<Integer> Ys = null;
            
            for (int i = 2; i <= K; i++){
                if (K%i == 0 && !Ys.contains(i)){
                    Ys.add(i);
                    K /= i;
                    Y++;
                    i = 1;
                }
            }
            System.out.println(Y);

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static boolean isInArray(int[] arr, int x){
        for ( int i = 0; i < arr.length ; i++){
            if (arr[i] == x) return true;
        }
        return false;
    }
}
