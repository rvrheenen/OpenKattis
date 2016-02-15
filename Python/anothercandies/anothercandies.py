T = int(input())
for t in range(T):
    skipBlank = input()
    N = int(input())
    sum = 0
    for n in range(N):
        sum+= int(input())
    if (sum % N == 0):
        print("YES")
    else:
        print("NO")

