N = int(input())
T = input().split(" ")
T = [int(x) for x in T]
T = sorted(T, reverse=True)
max = 0
for i in range(N):
    cur = int(T[i])+i+2
    if cur > max:
        max = cur
print(max)
    
