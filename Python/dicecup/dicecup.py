dice = [int(x) for x in input().split()]
for i in range(min(dice) + 1, max(dice) + 2):
    print(i)