nCases = int(input())
for i in range(nCases):
    case, n = [int(x) for x in input().split()]
    print("%d %d %d %d" % (case, ((n*(n+1))/2), n**2, n*(n+1)))