#include <stdio.h>
#include <stdbool.h>
#include <string.h>
 
bool compare(char *pattern, char *string);
 
int main() {

    int N;
    int Q;
    scanf("%d %d", &N, &Q);
    char *words[N];

    for (int i = 0; i < N ; i++){
        scanf("%s", words[i]);
    }
    for (int i = 0; i < N ; i++){
        printf("%s", words[i]);
    }
    
    return 0;
}
 
 
bool compare(char *pattern, char *string) {
    if(*pattern=='\0' && *string=='\0')
        return true;
    if(*pattern=='*')
        return compare(pattern+1,string) || compare(pattern,string+1);
    return false;
}