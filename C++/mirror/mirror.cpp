#include <iostream>
#include <string>
using namespace std;

int main(int argc, char const *argv[]) {
    int rows, columns, cases;

    cin >> cases;
    
    for (int c = 0; c < cases; c++) {
        cout << "Test " << c + 1 << endl;
        cin >> rows;
        cin >> columns;
        char pixels[rows][columns]; 

        for (int i = 0; i < rows; i++) {
            cin >> pixels[i];
        }

        for (int i = rows - 1; i >= 0; i--) {
            for (int j = columns - 1; j >= 0; j--) {
                std::cout << pixels[i][j];
            }
            std::cout << "\n";
        }
    }

    return 0;
}