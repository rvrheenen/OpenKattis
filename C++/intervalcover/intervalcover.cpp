#include <stdio.h>
#include <stdlib.h>
#include <utility>
#include <queue>
#define pdd pair<double, double>
#define pdi pair<double, int>

using namespace std;

// Should work, but there are still some bugs

struct comp {
    bool operator() (const pdi &a, const pdi &b) {
        return a.first > b.first;
    }
};

vector<int> indexes;

pdd intervals[10001];
int n;

int main(int argc, char const *argv[]) {
    double A, B, x, y, u, v, last, max;
    int index, maxIndex;

    freopen("intervalcover.in", "r", stdin);
    
    while(!feof(stdin)) {
        priority_queue< pdi, vector< pdi >, comp > Q;
        scanf("%lf %lf", &A, &B);
        scanf("%d", &n);
        for (int i = 0; i < n; i++) {
            scanf("%lf %lf", &x, &y);
            if (y < A || x > B) continue; 
            if (x < A) x = A;
            if (y > B) y = B;
            intervals[i] = make_pair(x, y);
            Q.push(make_pair(x, i));
        }
        last = A;
        while (!Q.empty()) {
            max = last;
            maxIndex = -1;
            while (!Q.empty() && Q.top().first <= last) {
                index = (int) Q.top().second;
                y = intervals[index].second;
                if (y > max) {
                    max = y;
                    maxIndex = index;
                }
                Q.pop();
            }
            if (maxIndex == -1) {
                break;
            }
            last = max;
            indexes.push_back(index);
        }
        if (maxIndex != -1) {
            printf("%lu\n", indexes.size());
            for (int i = 0; i < indexes.size(); i++) {
                printf("%d ", indexes[i]);    
            }
            printf("\n");
        } else {
            printf("impossible\n");
        }
        indexes.clear();
    }
    
    return 0;
}