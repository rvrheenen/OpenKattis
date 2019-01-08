for _ in range(int(input())):
    a,b,c = [int(x) for x in input().split()]
    print("Possible" if c in [a+b, a-b, b-a, a*b, a/b, b/a] else "Impossible")
