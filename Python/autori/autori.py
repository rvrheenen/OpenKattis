line = input()
abbr = line[0]
for i in range(len(line)):
    if line[i] == "-":
        abbr += line[i+1]
print(abbr)
