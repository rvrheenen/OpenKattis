import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AveragesHard {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++){
            br.readLine();
            String[] inp = br.readLine().split(" ");
            int cs  = Integer.parseInt(inp[0]);
            int ec  = Integer.parseInt(inp[1]);
            int total = cs + ec;

            int count = 0;
            int[] csIQs = new int[cs];
            int[] ecIQs = new int[ec];
            while (count < total){
                int[] IQline = getNextIntLine(br);
                for (int j = 0; j < IQline.length; j++){
                    if (j+count < cs) {
                        csIQs[j+count] = IQline[j];
                    } else {
                        ecIQs[j+count-cs] = IQline[j];
                    }
                }
                count += IQline.length;
            }
            int amount = 0;
            double sumcsIQs = sum(csIQs);
            double sumecIQs = sum(ecIQs);
            for (int j = cs - 1; j >= 0; j--){
                if ( sumcsIQs/cs < ((sumcsIQs - csIQs[j])/(cs - 1)) && sumecIQs/ec < ((sumecIQs + csIQs[j])/(ec + 1)) ){
                    amount++;
                } 
            }
            System.out.println(amount);
        }
    }

    public static int[] getNextIntLine(BufferedReader br) throws IOException{
        String[] integersInString = br.readLine().split(" ");
        int a[] = new int[integersInString.length];
        for (int i = 0; i < integersInString.length; i++) {
            a[i] = Integer.parseInt(integersInString[i]);
        }
        return a;
    }

    public static Double sum(int[] a){
        double r = 0;
        for (int i = 0 ; i < a.length; i++){
            r += a[i];
        }
        return r;
    }
}