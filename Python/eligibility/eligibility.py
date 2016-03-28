N = input()
for i in range(int(N)):
    inp = input().split()
    name = inp[0]
    date1 = inp[1].split("/")
    date2 = inp[2].split("/")
    courses = int(inp[3])
    if (int(date1[0]) >= 2010 or int(date2[0]) >= 1991):
        eligible = "eligible"
    elif courses > 40:
        eligible = "ineligible"
    else:
        eligible = "coach petitions"
    print(name, eligible)