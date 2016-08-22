N = int(input())

for case in range(N):
    l1 = input()
    l2 = input()
    l3 = ""
    for j in range(len(l1)):
        l3 += "." if l1[j] == l2[j] else "*"
    print(l1)
    print(l2)
    print(l3)
    print("")