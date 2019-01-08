for _ in range(int(input())):
    gnomes = [int(x) for x in input().split()]
    for i in range(1, len(gnomes) - 1):
        if gnomes[i+1] - gnomes[i] is not 1:
            print(i+1)
            break
