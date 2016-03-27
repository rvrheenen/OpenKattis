#include <stdio.h>

int main(void){
    int inp [10];
    int count = 1;
    int tmp;
    for (int i = 0; i < 10; i++){
        scanf("%d", &tmp);
        inp[i]  = tmp%42;
        for (int j = 0; j < i; j++){
            if (inp[j] == inp[i]){
                break;
            } else if (j == i -1){
                count++;
            }
        }
    }
    printf("\n%d", count);
}