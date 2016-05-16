order = ["whitesp", "lower", "upper", "symbols"]
stats = {"whitesp" : 0, "lower" : 0, "upper" : 0, "symbols" : 0}

line = input()
for letter in line:
    l = ord(letter)
    if (l >= 65 and l <= 90):
        stats["upper"] += 1
    elif l >= 97 and l <= 122:
        stats["lower"] += 1
    elif l == 95:
        stats["whitesp"] += 1
    else:
        stats["symbols"] +=1

total = sum([stats[o] for o in order])
for stat in order:
    print(stats[stat]/total)
