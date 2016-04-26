first = True
while(True):
    N = int(input())
    if N == 0:
        break
    if not first:
        print()
    else:
        first = False

    # Get input lines    
    lines = []
    for i in range(N):
        lines.append([x for x in input()])

    # Add spaces at the end to make the lists of same length
    maxlen = len(max(lines, key=len))
    for i in range(len(lines)):
        linelen = len(lines[i])
        lines[i] = [x for x in ("".join(lines[i])+(" "*(maxlen-linelen)))]

    # Rotate
    rotated =  [list(elem) for elem in zip(*lines[::-1])]
    
    # Change the symbols after rotating
    for x in range(len(rotated)): 
        for y in range(len(rotated[x])):
            if rotated[x][y] == "|":
                rotated[x][y] = "-"
            elif rotated[x][y] == "-":
                rotated[x][y] = "|"

    # Print output 
    for x in range(len(rotated)):
        print("".join(rotated[x]).rstrip())
