import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Excursion {

    public static void main(String[] args) {

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            String inp = br.readLine();
            int[] digits = new int[3];
            long x = 0;
            for (int i = 0; i < inp.length(); i++){
                for (int j = Character.digit(inp.charAt(i), 10) + 1; j < 3; j++){
                    x += digits[j];
                }
                digits[Character.digit(inp.charAt(i), 10)] += 1;
            }
            System.out.println(x);
        } catch(Exception e){
            e.printStackTrace();    
        }
    }
}