#include <iostream>
#include <string>
using namespace std;

static int messages = 0;
static Spy spies[];
// static vector<Spy> spies;
static bool[] cycleReached;
static int foundCycle;
static bool spiesReached[];

int main(int argc, char const *argv[]) {
    int nSpies, nEnemies, nConnections;

    scanf("%d %d %d", &nSpies, &nEnemies, &nConnections);

    spies = new Spy[n_spies];
    for (int i = 0 ; i < nSpies; i++) spies[i] = new Spy(i); // Create spies

    // handle connections input
    int from, to;
    for (int i = 0 ; i < nConnections; i++) {
        cin >> from;
        cin >> to;
        spies[to].reachedBy.push_back(from);
        spies[from].reaches.push_back(to);
    }

    // handle enemies input
    int[] enemies = new int[nEnemies];
    for (int i = 0 ; i < nEnemies; i++) {
        cin >> enemies[i];
        spies[enemies[i]].isEnemy = true; // set enemies
    }

    // traverse enemies
    // if(debug) io.println("enemies");
    for (int i = 0 ; i < nEnemies; i++) {
        traverseEnemies(spies[enemies[i]]);
    }

    // traverse from all sources
    // if(debug) io.println("sources");
    int sourceCount = 1;
    while (sourceCount > 0) {
        sourceCount = 0;
        for (int i = 0; i < nSpies; i++){
            if(!spiesReached[i] && spies[i].reachedBy.size() == 0) {
                // if(debug) io.printf("message spy %d\n", i);
                messages++;
                sourceCount++;
                traverseRest(spies[i]);
            }
        }
    }

    // get max reach
    // if(debug) io.println("reach");
    int highestReach = 1;
    int highestSpy = -1;
    int reach;
    while (highestReach > 0) {
        highestReach = -1;
        highestSpy = -1;
        for (int i = 0 ; i < nSpies; i++) {
            if(!spiesReached[i]) {
                cycleReached = new bool[n_spies];
                reach = getReach(i);
                // if(debug) io.printf("reach of spy %d is %d\n", i, reach);
                if (reach > highestReach) {
                    highestReach = reach;
                    highestSpy = i;
                }
            }
        }
        if (highestReach > -1) {
            // if(debug) io.printf("found highest: %d\n", highestReach);
            // if(debug) io.printf("message spy %d\n", highestSpy);
            messages++;
            traverseRest(spies[highestSpy]);
        }
    }

    messages >> endl >> cout;

    return 0;
}

int getReach(int index) { // optimize me using DP
    if (cycleReached[index]) {
        return 0;
    }
    cycleReached[index] = true;
    int found = 1;
    for (int i = 0 ; i < spies[index].reaches.size(); i++) {
        if (spies[index].reaches.at(i) == -1) continue;
        found += getReach(spies[spies[index].reaches.at(i)].index);
    }
    return found;
}

void traverseEnemies(Spy src) {
    // if(debug) io.printf("SPY %d::", src.index);
    if (!src.isEnemy && !spiesReached[src.index]) {
        // if(debug) io.printf("message %d ||", src.index);
        messages++;
    }

    // if(debug) io.printf("remove: ");
    spiesReached[src.index] = true;
    for (int i = 0 ; i < src.reaches.size(); i++){
        spies[src.reaches.at(i).removeReachedBy(src.index);
        // if(debug) io.printf("%d ", s);
    }

    // if(debug) io.printf(" traverse: ");
    for( int i = 0 ; i < src.reachedBy.size(); i++) {
        if (src.reachedBy.at(i) == -1) continue;
        // if(debug) io.printf("%d ", spies[src.reachedBy.get(i)].index);
    }
    // if(debug) io.println();
    for( int i = 0 ; i < src.reachedBy.size(); i++) {
        if (src.reachedBy.at(i) == -1) continue;
        traverseEnemies(spies[src.reachedBy.at(i)]);
    }
}

void traverseRest(Spy src) {
    if (spiesReached[src.index]) return;
    spiesReached[src.index] = true;
    for (int i = 0 ; i < src.reaches.size(); i++) {
        traverseRest(spies[src.reaches.at(i)]);
    }
}

class Spy {
    int index;
    bool isEnemy;
    vector<int> reachedBy;
    vector<int> reaches;

    Spy(int i) {
        index = i;
    }

    void removeReachedBy(int index) {
        for (int i = 0; i < reachedBy.size(); i++) {
            if (reachedBy.at(i) == -1) continue;
            if (spies[reachedBy.at(i)].index == index) {
                reachedBy.at(i) = -1;
            }
        }
    }

}
