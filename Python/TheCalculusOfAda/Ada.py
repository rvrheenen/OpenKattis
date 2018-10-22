#The Calculus of Ada, OpenKattis, https://open.kattis.com/problems/ada
## Sln by Craigory Coppola

import sys

ints = [int(x) for x in sys.stdin.readline().split()][1:]

layers = [0]

def solve_recursive(nums):
	differences = [nums[i+1]-nums[i] for i in range(len(nums)-1)]
	layers[0]+=1
	if len(differences) == 0:
		return nums[-1]
	elif len(set(differences)) == 1:
		return nums[-1] + differences[0]
	next_difference = solve_recursive(differences)
	return nums[-1]+next_difference

ans = solve_recursive(ints)
	
print(layers[0], ans)
	
