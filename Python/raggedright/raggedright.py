lines = list()
longest = 0
while(True):
    try:
        line = input()
        if len(line) > longest:
            longest = len(line)
        lines.append(line)
    except EOFError:
        break
raggedness = 0
for i in range(len(lines) - 1):
    raggedness += (longest - len(lines[i])) ** 2
print(raggedness)
