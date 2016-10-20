while(True):
    jars = [int(x) for x in input().split()]
    if sum(jars) == 0:
        break
    if sum(jars) == 13:
        print("Never speak again.")
    elif jars[0] > jars[1]:
        print("To the convention.")
    elif jars[1] > jars[0]:
        print("Left beehind.")
    elif jars[1] == jars[0]:
        print("Undecided.")