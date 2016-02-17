while(True):
    try:
        inp = input()
    except EOFError:
        break
    a,b = inp.split()
    print(abs(int(a)-int(b)))
