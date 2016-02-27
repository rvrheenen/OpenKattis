import java.io.BufferedReader;
import java.io.InputStreamReader;

public class cd {

     public static void main(String[] args) {

        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        String[] inp;

        while (true){
            String line = "";
            try {        
                line = bi.readLine();
            } catch(Exception e){
                e.printStackTrace();
            }
            inp = line.split(" ");
            N = Integer.parseInt(inp[0]);
            M = Integer.parseInt(inp[1]);
            if (N == 0 && M == 0) break;
            int[] ncd = new int[N];
            for (int i = 0; i < N; i++){
                try {
                    ncd[i] = Integer.parseInt(bi.readLine());
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
            int[] mcd = new int[M];
            for (int i = 0; i < M; i++){
                try {
                    mcd[i] = Integer.parseInt(bi.readLine());
                } catch(Exception e){
                    e.printStackTrace();
                }
            }
            int n = 0;
            int m = 0;
            int c = 0;
            while (n<N && m<M){
                if (ncd[n] < mcd[m]) n++;
                else if (ncd[n] > mcd[m]) m++;
                else {
                    n++;
                    m++;
                    c++;
                }
            }
            System.out.println(c);
        }
    }
}
