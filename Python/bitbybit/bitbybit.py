while(True):
    N = int(input())
    if N == 0:
        break
    bits = ["?"]*32
    for x in range(N):
        line = input().split()
        i = int(line[1])
        if line[0] == "OR" or line[0] == "AND":
            j = int(line[2])

        if line[0] == "CLEAR":
            bits[i] = 0
        elif line[0] == "SET": 
            bits[i] = 1
        elif line[0] == "OR":
            if bits[i] == 1 or bits[j] == 1:
                bits[i] = 1
            elif bits[i] == 0 and bits[j] == 0:
                bits[i] = 0
            else:
                bits[i] = "?"
        elif line[0] == "AND":
            if bits[i] == 0 or bits[j] == 0:
                bits[i] = 0
            elif bits[i] == 1 and bits[j] == 1:
                bits[i] = 1
            else:
                bits[i] = "?"

    print(("".join(reversed([str(x) for x in bits]))) )