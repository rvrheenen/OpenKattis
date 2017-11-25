n_cases = int(input())
for i in range(n_cases):
    case = [int(x) for x in input().split()]
    if (case[1] - case[2] > case[0]):
        print("advertise")
    elif (case[1] - case[2] < case[0]):
        print("do not advertise")
    else:
        print("does not matter")
