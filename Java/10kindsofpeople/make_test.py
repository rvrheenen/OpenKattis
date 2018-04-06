import sys
import random

def main():
    rows = int(sys.argv[1]) if len(sys.argv) > 1 else 10
    cols = int(sys.argv[2]) if len(sys.argv) > 2 else 10
    queries = int(sys.argv[3]) if len(sys.argv) > 3 else 0
    mode = int(sys.argv[4]) if len(sys.argv) > 4 else 0 # likelynes to repeat same

    print(rows, cols)
    map = []
    prev = random.randint(0,1)
    for i in range(rows):
        map.append([])
        for j in range(cols):
            next = random.randint(0,1)
            for k in range(mode):
                if next != prev:
                    next = random.randint(0,1)
                else:
                    break
            map[i].append(next)
            print(map[i][j], end="")
            prev = next
        print()

    print(queries)
    for i in range(queries):
        r1 = random.randint(0, rows - 1)
        c1 = random.randint(0, cols - 1)
        while(True):
            r2 = random.randint(0,rows - 1)
            c2 = random.randint(0,cols - 1)
            if map[r1][c1] == map[r2][c2]:
                break
        print(r1+1,c1+1,r2+1,c2+1)



if __name__ == '__main__':
    main()
