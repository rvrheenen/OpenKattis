params = [int(x) for x in input().split()]

for i in range(params[0]):
    line = input()
    for j in line:
        out = "".join([ x*params[3] for x in line ])
    for j in range(params[2]):
        print(out)