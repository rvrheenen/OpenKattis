N = input()
dict = {}
for i in range(int(N)):
    inp = input().split()
    if dict.get(inp[1]):
        if dict.get(inp[1]) == inp[0]:
            if inp[0] == "entry":
                print(inp[1], "entered (ANOMALY)")
            else:
                print(inp[1], "exited (ANOMALY)")
        else:
            if inp[0] == "entry":
                print(inp[1], "entered")
            else:
                print(inp[1], "exited")
        dict.update({inp[1]:inp[0]})
    else:
        dict.update({inp[1]:inp[0]})
        if inp[0] == "entry":
            print(inp[1], "entered")
        else:
            print(inp[1], "exited (ANOMALY)")