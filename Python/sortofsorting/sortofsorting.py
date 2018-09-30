first = True
while(True):
    n = int(input())
    if n == 0:
        break
    if first:
        first = False
    else:
        print("")

    names = []
    for i in range(n):
        names.append(input())

    names = sorted(names, key=lambda v: (v[:2]) )

    for name in names:
        print(name)
