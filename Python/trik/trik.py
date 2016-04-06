swaps = input()
cups = [1,0,0]
for swap in swaps:
    if swap == "A":
        tmp = cups[0]
        cups[0] = cups[1]
        cups[1] = tmp
    elif swap == "B":
        tmp = cups[2]
        cups[2] = cups[1]
        cups[1] = tmp
    elif swap == "C":
        tmp = cups[0]
        cups[0] = cups[2]
        cups[2] = tmp
for i in range(len(cups)):
    if cups[i] == 1:
        print(i+1)