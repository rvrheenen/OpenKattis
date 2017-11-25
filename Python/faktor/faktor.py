articles, impact = [int(x) for x in input().split()]

if (articles == 1 or impact == 1):
    print(articles * impact)
else:
    print(articles * (impact - 1) + 1)
