/*
Interesting reading for this problem:
https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;

public class PrimeSieve {

    public static void main(String[] args){

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String[] inp = br.readLine().split(" ");
            int n        = Integer.parseInt(inp[0]);
            int Q        = Integer.parseInt(inp[1]);
            
            BitSet primes = new BitSet();

            for (int i = 2; i < n+1; i++){
                primes.set(i);
            }

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (primes.get(i)) {
                    for (int j = i + i; j < n+1; j += i){
                        primes.clear(j);
                    }
                }
            }
         
            int count = 0;
            for (int i = 0; i < n+1; i++) {
                if (primes.get(i)){
                    count++;
                }
            }
            System.out.printf("%d\n", count);
            
            for (int i = 0; i < Q; i++){
                if (primes.get(Integer.parseInt(br.readLine()))){
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }          
            }   	
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
