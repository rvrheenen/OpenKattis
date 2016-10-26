# WORKS BUT ISN'T FAST ENOUGH
first_run = True
while(True):
    inp = input().split()
    if len(inp) == 1:
        break
    if first_run:
        first_run = False
    else:
        print()
    nPlayers, nGames = [int(x) for x in inp]
    resultsW = [0] * nPlayers
    resultsL = [0] * nPlayers
    for i in range( int( ((nGames*nPlayers)*(nPlayers - 1)) / 2 ) ):
        p1, p1move, p2, p2move = [int(x) if x.isdigit() else x for x in input().split()]
        if p1move == p2move:
            continue
        if (p1move == "scissors" and p2move == "paper") or (p1move == "paper" and p2move == "rock") or (p1move == "rock" and p2move == "scissors"):
            resultsW[p1-1] += 1
            resultsL[p2-1] += 1
        else:
            resultsW[p2-1] += 1
            resultsL[p1-1] += 1

    for i in range(nPlayers):
        w_plus_l = resultsL[i] + resultsW[i]
        if  w_plus_l == 0:
            print("-")
        else:
            print("%.3f" % (resultsL[i] / w_plus_l))
    print("\n\n\n\n\n\n\n")
    print(resultsW)