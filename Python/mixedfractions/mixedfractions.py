while(True):
    inp = [int(x) for x in input().split()]
    if inp[0] == 0 and inp[1] == 0:
        break
    print(inp[0]//inp[1], inp[0]%inp[1], "/", inp[1])