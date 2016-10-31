nCups = int(input())

cups = {}
for i in range(nCups):
    line = input().split()
    if line[0].isnumeric():
        cups[int(line[0])/2] = line[1]
    else:
        cups[int(line[1])] = line[0]
print("\n".join([cups[k] for k in sorted(cups.keys())]))