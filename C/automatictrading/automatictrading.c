#include <stdio.h>  
#include <stdlib.h>  

int main(void){
    char *trades = (char *)malloc(sizeof(char) * 100001);
    char c = '\0';
    int tradeslength = 0;
    int i = 0;
    int seq = 0;
    int queries = 0;
    int points[2] = {0}; 

    while(c != '\n'){
        c = getchar();
        trades[i++] = c;

    }
    trades[i]='\0';
    tradeslength = i;

    scanf("%d", &queries);
    for (i = 0; i < queries; i++) {
        scanf("%d %d", &points[0], &points[1]);
        seq = 0;
        while (((points[0] + seq) < tradeslength) && ((points[1] + seq) < tradeslength) ) {
            if (trades[points[0] + seq] == trades[points[1] + seq]) {
                seq++;
            } else {
                break;
            }
        }
        printf("%d\n", seq);
    }
}
