import java.util.Scanner;
import java.lang.Math;

// From BAPC 2016
public class OlderBrother {

    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        long n = in.nextLong();
        double temp = n;
        
        int i=2;
        
        while(!isPrime(temp) && temp>2){
            temp = Math.pow(n, (1.0/i));
            i++;
        }
        if(temp<2){
            System.out.println("no");
        } else {
            System.out.println("yes");
        }
    }

    public static boolean isPrime(double n){
        long temp = Math.round(n); 
        if(!(n-temp > -0.0000000000001 && n-temp < 0.0000000000001)){
            return false;       
        }
        n = (double) temp;
        if(n<2){
            return false;
        } if(n==2 || n==3){
            return true;
        } if(n%2==0 || n%3==0){
            return false;
        }
        long sqrtN = (long)Math.sqrt(n)+1;
        for(long i=6L; i<=sqrtN; i+=6){
            if(n%(i-1) == 0 || n% (i+1) == 0){
                return false;
            }
        }
        return true;
    }
}
