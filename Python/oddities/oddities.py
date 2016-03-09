N = input()
for n in range(int(N)):
    x = int(input())
    ans = "is even" if x%2 == 0 else "is odd"
    print(x, ans)
