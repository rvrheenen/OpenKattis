n_swathers, n_stages = [int(x) for x in input().split()]

swathers = []
for i in range(n_swathers):
    swathers.append([int(x) for x in input().split()])

for i in range(n_swathers):
    for j in range(n_stages):
        if i == 0:
            if j > 0:
                swathers[i][j] += swathers[i][j - 1]
        else: #if i > 0
            if j > 0:
                swathers[i][j] += max(swathers[i-1][j], swathers[i][j-1])
            else:
                swathers[i][j] += swathers[i-1][j]

        if j == n_stages - 1:
            print(swathers[i][j], end=" ")
