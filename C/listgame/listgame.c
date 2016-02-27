/* WORKS BUT EXCEEDS TIME LIMIT*/
#include <stdio.h>

int main(void){
	int K;
	int Y = 0;
	
	scanf("%d", &K);
	
	int i;
	for ( i = 2; i <= K; i++){
		if (K%i == 0){
			K = K/i;
			Y++;
			i = 1;
		}
	}

	printf("%d", Y);
}