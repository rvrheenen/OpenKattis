# Assignment:
# determine the minimal integer N such that L≤N≤D and the sum of its digits is X
# determine the maximal integer M such that L≤M≤D and the sum of its digits is X

def calc_sum_of_digits(num):
    return sum([int(x) for x in str(num)])

L = int(input())
D = int(input())
X = int(input())

M = 0
N = 0

for i in range(L,D+1):
    if (calc_sum_of_digits(i) == X):
        N = i
        break

for i in range(D, L-1, -1):
    if (calc_sum_of_digits(i) == X):
        M = i
        break

print(N)
print(M)