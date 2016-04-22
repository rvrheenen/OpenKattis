first = True
while(True):
    N = int(input())
    if N == 0:
        break
    if first:
        first = False
    else:
        print("")

    names = []
    for i in range(N):
        names.append(input())

    names = sorted(names, key=lambda v: (v[0:2].upper(), v[0].islower()) )
    
    for name in names:
        print(name)