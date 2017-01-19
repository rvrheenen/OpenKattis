#include <iostream>
#include <string>
using namespace std;

int main(int argc, char const *argv[]) {
    int nFruits, capacity, count, bestCount, stomach, fruit;

    cin >> nFruits >> capacity;
    int fruits [nFruits];
    count = 0;
    for (int i = 0 ; i < nFruits ; i++) {
        scanf("%d", &fruits[i]);
    }
    bestCount = 0;
    for (int i = 0; i < nFruits; i++) {
        stomach = 0;
        count = 0;
        for (int j = i; j < nFruits; j++) {
            if (fruits[j] <= capacity - stomach) {
                count++;
                stomach += fruits[j];
            }
            if (stomach == capacity) {
                break;
            }
        }
        if (count > bestCount) {
            bestCount = count;
        }
    }
    cout << bestCount << endl;
    return 0;
}