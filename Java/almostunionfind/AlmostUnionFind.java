import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AlmostUnionFind {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int amount_of_numbers, amount_of_commands;
        String[] inp;

        String line = "";
            line = bi.readLine();
        inp = line.split(" ");

        amount_of_numbers  = Integer.parseInt(inp[0]);
        amount_of_commands = Integer.parseInt(inp[1]);

        int[] numbers = new int[amount_of_numbers];
        for (int i = 0; i < amount_of_numbers; i++){
            numbers[i] = i + 1; 
        }

        for (int i = 0; i < amount_of_commands; i++){
            inp = bi.readLine().split(" ");
            command[] = new int[] { Integer.parseInt(inp[0]), Integer.parseInt(inp[1]), Integer.parseInt(inp[2]) }; 
            switch (Integer.parseInt(inp[0])) {
                case 1:  perform_union(Integer.parseInt(inp[1]), Integer.parseInt(inp[2]));
                    break;
                case 2:  perform_move(Integer.parseInt(inp[1]), Integer.parseInt(inp[2]));
                    break;
                case 2:  perform_return(Integer.parseInt(inp[1]), Integer.parseInt(inp[2]));
                    break; 
            }
        }
    }
}
