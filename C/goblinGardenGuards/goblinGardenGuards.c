#include <stdio.h>

int main(void){
    int G;
    scanf("%d", &G);
    int gCoords [G][2];
    for (int i = 0; i < G; i++){
        scanf("%d %d", &gCoords[i][0], &gCoords[i][1]);
    }

    int S;
    scanf("%d", &S);
    int sCoords [S][3];
    for (int i = 0; i < S; i++){
        scanf("%d %d %d", &sCoords[i][0], &sCoords[i][1], &sCoords[i][2]);    
    }

    int goblinsLeft = G;

    for (int g = 0; g < G; g++){ // for every goblin
        for (int s = 0; s < S; s++){ // for every sprinkler
            int x = gCoords[g][0] - sCoords[s][0];
            int y = gCoords[g][1] - sCoords[s][1];
            if (x*x+y*y <= sCoords[s][2]*sCoords[s][2]) {
                goblinsLeft--;
                break;
            }
        }
    }
    printf("%d\n", goblinsLeft);
}