import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Listgame {

     public static void main(String[] args) {

        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            int K = Integer.parseInt(bi.readLine());
            int Y = 0;
            
            for (int i = 1; i*i <= K; i++){
                if (K%i == 0){
                    K /= i;
                    Y++;
                    i = 1;
                }
                if (K == 1) Y++;
            }
            System.out.println(Y);

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

// 65536  => 16
// 127381 => 3
