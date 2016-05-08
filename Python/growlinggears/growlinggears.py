N = int(input())
for n in range(N):
    highestT = 0
    highestG = 0
    for g in range(int(input())):
        a,b,c = [int(x) for x in input().split()]
        R = abs(b/(-a*2)) # T = -a*R**2 + b*R + c
        T  = (-a*(R**2)) + (b*R) + c
        if T > highestT:
            highestG = g+1
            highestT = T
    print(highestG)
