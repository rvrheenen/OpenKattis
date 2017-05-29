pieces = [int(x) for x in input().split()]

while (pieces != [1,2,3,4,5]):
    for i in range(4):
        if pieces[i] > pieces[i+1]:
            tmp = pieces[i]
            pieces[i] = pieces[i+1]
            pieces[i+1] = tmp
            print(" ".join([str(p) for p in pieces]))
