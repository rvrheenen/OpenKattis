nCases = int(input())
for i in range(nCases):
    the_sum, diff = [int(x) for x in input().split()]
    if diff > the_sum:
        print("impossible")
    else:
        team_a = ((the_sum + diff) / 2.0)
        if team_a != int(team_a):
            print("impossible")
        else:
            team_b = the_sum - team_a
            print("%d %d" % (max(team_a, team_b), min(team_a, team_b)))