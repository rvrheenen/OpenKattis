case = 1
while(True):
    try:
        line = [int(x) for x in input().split()][1:]
        print("Case %d: %d %d %d" % (case, min(line), max(line), max(line) - min(line)))
        case += 1
    except EOFError:
        break