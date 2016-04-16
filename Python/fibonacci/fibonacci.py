#Works but way too slow in the bigger numbers..
def F(n):
    if n >= 2:
        return F(n-1) + F(n-2)
    else:
        return str(n)

case = 1
while(True):
    try:
        inp = input()
        print("Case "+ str(case) +": " + str((F(int(inp))).count(input())) )
        case += 1
    except EOFError:
        break
    