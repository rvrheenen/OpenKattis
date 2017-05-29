while True:
    num_heads, num_knights = [int(x) for x in input().split()]
    if num_knights + num_heads == 0:
        break

    # Read the heads
    heads = []
    for i in range(num_heads):
        heads.append(int(input()))
    heads = sorted(heads)

    # Read the knights
    knights = []
    for i in range(num_knights):
        knight = int(input())
        if knight >= heads[0]: # skip all knights that are smaller than the smallest head (small optimisation)
            knights.append(knight)
    knights = sorted(knights)

    if len(knights) < num_heads: 
        print("Loowater is doomed!")
        continue

    hire_cost = 0
    k = -1
    doomed = False
    for head in heads:
        while k < len(knights):
            k += 1
            if k >= len(knights):
                doomed = True
                break
            if knights[k] >= head:
                hire_cost += knights[k]
                break
    
    if doomed:
        print("Loowater is doomed!")
    else:
        print(hire_cost)
