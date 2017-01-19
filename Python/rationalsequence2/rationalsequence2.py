nCases = int(input())
for c in range(nCases):
    line = input().split()
    p = int(line[1].split('/')[0])
    q = int(line[1].split('/')[1])
    path = []
    while (p > 1 or q > 1):
        if p > q:
            path.append("R")
            p -= q
        else:
            path.append("L")
            q -= p
    n = 0
    for i in range(len(path) - 1, -1, -1):
        if path[i] == "R":
            n = (2 * (n + 1))
        else:
            n = (2 * n + 1)
    print("%s %d" % (line[0], n + 1))