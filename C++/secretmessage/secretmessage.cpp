#include <iostream>
#include <string>
#include <string.h>
#include <math.h>
using namespace std;

int main(int argc, char const *argv[]) {
    int nLines;
    int square;
    cin >> nLines;

    for (int c = 0; c < nLines; c++) {
        string msg;
        cin >> msg;
        square = ceil(sqrt(msg.length()));
        for (int i = 0; i < (msg.size() - (square * square)); i++) {
            msg += "*";
        }
        char table[square][square];
        for (int i = 0; i < msg.size(); i++) {
            table[(int)floor(i/square)][i%square] = msg[i];
        }

        for (int i = 0; i < square; i++) {
            for (int j = square - 1; j >= 0; j--) {
                if (table[j][i] == '*') continue;
                cout << table[j][i];
            }
        }
        cout << endl;
    }
}