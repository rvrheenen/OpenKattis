from itertools import combinations

input = ['a', 'b', 'c', 'd']
input = ['3 8', '5 8']
input = [['3', '8'], ['5', '8'], ['2', '6']]

output = sum([map(list, combinations(input, i)) for i in range(len(input) + 1)], [])

print(output)
