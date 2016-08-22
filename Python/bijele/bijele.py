needed = [1,1,2,2,2,8]
have   = [int(x) for x in input().split()]

difference = []
for i in range(len(needed)):
    difference.append(needed[i] - have[i])

print(" ".join([str(x) for x in difference]))