#include <stdio.h>	

int main(void){
	int A,B,C,a,d,t,T = 0;
	int parked[100] = { 0 };

	if (scanf("%d %d %d", &A, &B, &C) == 0) return 1;

	for (int i = 1; i <= 3 ; i++){
		if (scanf("%d %d", &a, &d) == 0) return 1;
		for (int j = a-1; j < d-1; j++){
			parked[j]++;
		}
	}

	for (int i = 0; i < 100; i++){
		t = parked[i];
		if (t == 1){
			T += A;
		} else if (t == 2){
			T += (2 * B);
		} else if (t == 3){
			T += (3 * C);
		}
	}
	printf("%d\n", T);
}