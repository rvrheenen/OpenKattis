#include <stdio.h>
#include <stdbool.h>

int main(void){
	while(true){
		int n, s, t, p = 0, m = 0;

		if (scanf("%d", &n) == 0) return 1;
		if (n == -1) return 0;

		for (int i = 0; i < n; i++){
			if (scanf("%d %d", &s, &t) == 0) return 1;
			m += s * (t-p);
			p = t;
		}

		printf("%d miles\n",m);
	}
}