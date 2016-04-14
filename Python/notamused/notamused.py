day = 0
people = {}
while(True):
    try:
        inp = input()
    except EOFError:
        break
    inp = inp.split()
    if len(inp) == 1:
        if inp[0] == "OPEN":
            if day != 0:
                print()
            day += 1
            print("Day", day)
            people.clear()
        else:
            for person in sorted(people.keys()):
                print(person, " $", '%.2f' % (people.get(person)*0.1), sep='')
    else:
        if inp[0] == "ENTER":
            if not people.get(inp[1]):
                people.update({inp[1]:int(inp[2])})
            else:
                people.update({inp[1]:(int(inp[2]) - people.get(inp[1]))})    
        else:
            people.update({inp[1]:(int(inp[2]) - people.get(inp[1]))})