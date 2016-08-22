def solve(a,b,c):
    if a+b==c:
        return ("%s+%s=%s" % (a,b,c))
    if a-b==c:
        return ("%s-%s=%s" % (a,b,c))
    if a*b==c:
        return ("%s*%s=%s" % (a,b,c))
    if b != 0:    
        if a/b==c:
            return ("%s/%s=%s" % (a,b,c))
    if a==b+c:
        return ("%s=%s+%s" % (a,b,c))
    if a==b-c:
        return ("%s=%s-%s" % (a,b,c))
    if a==b*c:
        return ("%s=%s*%s" % (a,b,c))
    if c != 0:    
        if a==b/c:
            return ("%s=%s/%s" % (a,b,c))

a,b,c = [int(x) for x in input().split()]
print(solve(a,b,c))