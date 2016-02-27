// WORKS BUT NOT FAST ENOUGH
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Listgame {

     public static void main(String[] args) {

        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            int K = Integer.parseInt(bi.readLine());
            int Y = 0;
            
            for (int i = 2; i <= K; i++){
                if (K%i == 0){
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
}
