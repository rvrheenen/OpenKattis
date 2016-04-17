while(True):
    try:
        R, C = [float(x) for x in input().split()]
        print( ((R-C)**2) / (R**2) * 100)
    except EOFError:
        break
    break
