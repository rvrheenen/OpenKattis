keys = " ‘ 1 2 3 4 5 6 7 8 9 0 - = q w e r t y u i o p [ ] \  a s d f g h j k l ; ' z x c v b n m , . / ".upper().split()
while(True):
    try:
        line = input()
    except EOFError:
        break
    result = "".join([keys[keys.index(x)-1] if x is not " " else " " for x in line])
    print(result)