#include <iostream>
#include <string>
using namespace std;

int main(int argc, char const *argv[]) { //too slow!!
    int number;

    restart:
    while(true) {
        cin >> number;
        if (number == 0) {
            break;
        }
        for (int i = 1; i <= number + 1; i++) {
            if (number % i == 3) {
                cout << i << endl;
                goto restart;
            }
        }
        cout << "No such base" << endl;
    }
}