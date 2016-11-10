nBuses = int(input())
buses = sorted([int(x) for x in input().split()])

chain = 1
for i in range(1, nBuses + 1):
    if i < nBuses and buses[i - 1] == buses[i] - 1:
        chain += 1
    else:
        if chain > 2:
            print("%d-%d" % (buses[i - chain], buses[i - 1]), end=(" " if i < nBuses else "\n"))
        else:
            for j in range(chain):
                print(buses[i - chain + j], end=(" " if i < nBuses else "\n"))
        chain = 1