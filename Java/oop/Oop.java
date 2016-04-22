// It's simply too slow, need to look at storing (hashing?) previously checked words some time.

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Oop {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inp = br.readLine().split(" ");

        int N = Integer.parseInt(inp[0]);
        int Q = Integer.parseInt(inp[1]);
        String[] words = new String [N];

        for (int i = 0; i < N ; i++){
            words[i] = br.readLine();
        }
        int count = 0;
        String pattern;
        for (int i = 0; i < Q; i++){
            pattern = br.readLine();
            for (int j = 0; j < N; j++){
                if (matches(pattern, words[j])){
                    count++;
                }
            }
            System.out.println(count);
            count = 0;
        }
    }

    public static boolean matches(String pattern, String str) {
        if (str.length() == 0 && pattern.length() == 0) {
            return true;
        }
        if (str.length() == 0 && !pattern.equals("*")) {
            return false;
        }
        if (charsMatch(pattern, str)) {
            return matches(pattern.substring(1), str.substring(1));
        }
        if (charsMatch(pattern, '*')) {
            return matches(pattern.substring(1), str) || matches(pattern, str.substring(1));
        }
        return false;
    }
 
    private static boolean charsMatch(String s, char ch) {
        return s.length() > 0 && s.charAt(0) == ch;
    }
    private static boolean charsMatch(String s, String p) {
        return s.length() > 0 && p.length() > 0 && s.charAt(0) == p.charAt(0);
    }

}

// Function that also works but is even slower..
// public static boolean match(String text, String pattern) {
//   return text.matches(pattern.replace("*", ".*?"));
// }

// Function in C
// bool compare(char *pattern, char *string) {
//     if(*pattern=='\0' && *string=='\0')
//         return true;
//     if(*pattern=='*')
//         return compare(pattern+1,string) || compare(pattern,string+1);
//     return false;
// }

