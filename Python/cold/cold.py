N = input()
T = input().split(" ")
sum = 0
for t in T:
    if int(t)<0:
        sum+=1
print(sum)
