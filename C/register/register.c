#include <stdio.h>

int main(void){
    int regVal;
    int regSize [8] = {2,3,5,7,11,13,17,19};
    int tot = 1;
    int it = 0;
    for (int i = 0; i < 8; i++){
        scanf("%d", &regVal);
        it += tot * regVal;
        tot *= regSize[i];
    }
    printf("%d\n", tot - (it + 1));
}