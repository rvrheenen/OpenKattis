N = int(input())
for i in range(N):
    input() #skip empty line
    amounts = [int(x) for x in input().split()]
    G = [int(x) for x in input().split()]
    M = [int(x) for x in input().split()]
    print("Godzilla" if max(G)>=max(M) else "MechaGodzilla")