while(True):
    try:
        inp = [int(x) for x in input().split()]
        listsum = sum(inp)
        for i in inp:
            if listsum - i == i:
                print(i)
                break
    except EOFError:
        break