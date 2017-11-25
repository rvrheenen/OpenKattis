import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class FallingApart {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] array = new int[n];
		for(int i=0; i<n; i++){
			array[i]= in.nextInt();
		}

		Arrays.sort(array);

		int a = 0;
		int b = 0;

		for(int i=0; i<n; i++){
			if(i%2==0){
				a+=array[n-i-1];
			} else {
				b+=array[n-i-1];
			}
		}
		System.out.printf("%d %d\n",a,b);
	}

}
