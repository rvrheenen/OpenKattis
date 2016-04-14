T = int(input())
for i in range(T):
    input()
    cs, ec = [int(x) for x in input().split()]
    total = cs + ec
    
    IQs = [int(x) for x in input().split()]
    while len(IQs)<total:
        IQs += [int(x) for x in input().split()]
    csIQs = IQs[0:cs]
    ecIQs = IQs[cs:len(IQs)]
    total = 0
    for x in csIQs:
        if (sum(csIQs)/len(csIQs) < (sum(csIQs)-x)/(len(csIQs)-1)) and ( sum(ecIQs)/len(ecIQs) < (sum(ecIQs) + x) / (len(ecIQs)+1) ):
            total += 1
    print(total)

