def getTotalExpect(d):
    count = 0
    for a,b in zip(d[::2], d[1::2]):
        count += ((a+b)/2)
    return count

gunnar = [int(x) for x in input().split()]
emma = [int(x) for x in input().split()]

if getTotalExpect(gunnar) > getTotalExpect(emma):
    print("Gunnar")
elif getTotalExpect(gunnar) < getTotalExpect(emma):
    print("Emma")
else:
    print("Tie")