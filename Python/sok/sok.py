import operator

bought = [int(x) for x in input().split()]
recipe = [int(x) for x in input().split()]

ratios = map(operator.truediv, bought, recipe)
min_ratio = min(ratios)

left_over = []
for i in range(len(bought)):
    left_over.append(bought[i] - (recipe[i] * min_ratio))

print("{l[0]:.6f} {l[1]:.6f} {l[2]:.6f}".format(l=left_over))