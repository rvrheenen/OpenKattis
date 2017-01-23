#include <iostream>
#include <string>
using namespace std;

int main(int argc, char const *argv[]) {
    int lowerBound, upperBound, letter;
    
    cin >> lowerBound >> upperBound;
    
    for (int i = 0 ; i < upperBound; i++) {
        letter = i;
        while (letter > 0) {
            cout << (char) ('a' + letter % 26);
            letter /= 26;
        }
        cout << " ";
    }
}