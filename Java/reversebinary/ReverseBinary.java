import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReverseBinary {

    public static void main(String[] args){

        BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));

        try {
        	int N = Integer.parseInt(bi.readLine());
            String B = Integer.toString(N, 2);
            StringBuilder tmp = new StringBuilder();
            tmp.append(B);
            System.out.println(Integer.toString(Integer.parseInt(tmp.reverse().toString(),2)));

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}

