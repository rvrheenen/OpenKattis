import java.util.Scanner;

// From BAPC 2016
public class BattleSimulation {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        int i =0;
        
        while(i<line.length()){
            if(i<line.length()-2){
                char one = line.charAt(i);
                char two = line.charAt(i+1);
                char three = line.charAt(i+2);
                
                if(one!=two && one!=three && three!=one && three!=two){
                    System.out.print("C");
                    i+=3;
                    continue;
                } 
            }
            char one = line.charAt(i);
            if(one == 'R'){
                System.out.print("S");
            } else if(one == 'B') {
                System.out.print("K");
            } else if(one == 'L') {
                System.out.print("H");
            }
            i++;
        }
    }
}
