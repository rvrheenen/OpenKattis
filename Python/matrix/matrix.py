case = 1
while(True):
    try:
        a,b = [int(x) for x in input().split()]
        c,d = [int(x) for x in input().split()]
        input()
        determinant = a*d - b*c
        print("Case %d:\n%d %d\n%d %d" % (case, d/determinant, -b/determinant, -c/determinant, a/determinant))
        case += 1
    except EOFError:
        break