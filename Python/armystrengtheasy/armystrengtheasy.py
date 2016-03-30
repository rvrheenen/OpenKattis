N = int(input())
for i in range(N):
    input() #skip empty line
    amounts = [int(x) for x in input().split()]
    G = input().split()
    M = input().split()
    print("Godzilla" if max(G)>=max(M) else "MechaGodzilla")