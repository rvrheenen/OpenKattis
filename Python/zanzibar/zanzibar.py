N = int(input())
for i in range(N):
    imported = 0
    prev = 1
    for j in [int(x) for x in input().split()]:
        if (j > 2*prev):
            imported += j - (2*prev)
        prev = j
    print(imported)