#include <stdio.h>  
#include <stdlib.h>  
#include <stdint.h>  

#define ANSMOD 1000000007

int compare_function(const void *a,const void *b) {
    int *x = (int *) a;
    int *y = (int *) b;
    return *x - *y;
}

int main(void){
    unsigned long long number_of_problems, contest_time, a, b, c, t;
    unsigned long long penalty = 0;
    unsigned long long time_passed = 0;
    unsigned long long problems_solved = 0;
    int err, i;

    err = scanf("%llu %llu", &number_of_problems, &contest_time);
    err = scanf("%llu %llu %llu %llu", &a, &b, &c, &t);
    
    unsigned long long problem_times[number_of_problems];
    
    problem_times[0] = t;
    for (i = 1; i < number_of_problems; i++) {
        t = (((a * t) + b) % c) + 1;
        problem_times[i] = t;
    }

    qsort(problem_times, number_of_problems, sizeof(unsigned long long), compare_function);
    
    for (i = 0; i < number_of_problems; i++) {
        if (time_passed + problem_times[i] <= contest_time) {
            penalty = (penalty + problem_times[i] + time_passed) % ANSMOD;
            time_passed += problem_times[i];
            problems_solved++;
        } else {
            break;
        }
    }
    printf("%llu %llu\n", problems_solved, penalty);
}
