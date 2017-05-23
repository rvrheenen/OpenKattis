from itertools import combinations
import operator
from functools import reduce

n_ingreds = int(input())
ingredients = []
for i in range(n_ingreds):
    ingredients.append([int(x) for x in input().split()])

output = [combinations(ingredients, i) for i in range(len(ingredients) + 1)][1:]
max_diff = 1000000000

for comb in output:
    for thing in comb:
        diff = abs(sum([lis[1] for lis in thing]) - reduce(operator.mul, [lis[0] for lis in thing], 1))
        if diff < max_diff:
            if diff == 0:
                print(0)
                exit()
            max_diff = diff

print(max_diff)
