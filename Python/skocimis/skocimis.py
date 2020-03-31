kangaroos = [int(x) for x in input().split()]

biggest_dif = 0
for i in range(len(kangaroos) - 1):
    dif = kangaroos[i+1] - kangaroos[i]
    if dif > biggest_dif:
        biggest_dif = dif

print(dif - 1)