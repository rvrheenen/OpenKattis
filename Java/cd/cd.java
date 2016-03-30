import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class cd {

     public static void main(String[] args) throws IOException{

        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        int N, M;
        String[] inp;

        while (true){
            String line = "";
                line = bi.readLine();
            inp = line.split(" ");
            N = Integer.parseInt(inp[0]);
            M = Integer.parseInt(inp[1]);
            if (N == 0 && M == 0) break;
            int[] ncd = new int[N];
            for (int i = 0; i < N; i++){
                    ncd[i] = Integer.parseInt(bi.readLine());
            }
            int[] mcd = new int[M];
            for (int i = 0; i < M; i++){
                    mcd[i] = Integer.parseInt(bi.readLine());
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
