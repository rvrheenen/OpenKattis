import java.util.*;

public class Acm {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map<String, Integer> dictionary = new HashMap<String, Integer>();
        int answer = 0;
        int problemsSolved = 0;

        while(input.hasNext()){
            String log = input.nextLine();
            String[] data = log.split(" ");

            int minutes = Integer.parseInt(data[0]);

            if(minutes == -1){
                break;
            }
            String problem = data[1];

            if(data[2].equals("wrong")){
                if(dictionary.containsKey(problem)){
                    int n = dictionary.get(problem);
                    dictionary.put(problem, n + 20);
                } else {
                    dictionary.put(problem, 20);
                }
            } else {
                if(dictionary.containsKey(problem)){
                    int n = dictionary.get(problem);
                    minutes += n;
                }
                answer += minutes;
                problemsSolved++;
            }
        }
        System.out.println(problemsSolved + " " + answer);
    }
}