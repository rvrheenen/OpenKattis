inp = input().split()
N,M = inp
ncd = {}
for i in range(int(N)):
    x = input()
    ncd.update({x:x})

c = 0
tmp = -1
for i in range(int(M)):
    x = input()
    if (x in ncd and x != tmp):
        c += 1
        tmp = x
skipZeroes = input()
print(c)
