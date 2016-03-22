import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Babelfish {

    public static void main(String[] args){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> dict = new HashMap<String, String>();
        String[] inp;
        String line;
        String trans;

        try {
        	while (true){
        		line = br.readLine();
        		if (!line.equals("")){
        			inp = line.split(" ");
        			dict.put(inp[1], inp[0]);
        		} else {
        			break;
        		}
        	}
        	
        	while((line = br.readLine()) != null){
        		trans = dict.get(line);
        		if (trans != null){
        			System.out.println(trans);
        		} else{
        			System.out.println("eh");
        		}
        	}
        	
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
