word = input()
lines = []
line1 = "..#.."
line2 = ".#.#."
line3 = "#.{}.#".format(word[0])

for i in range(1, len(word)):
    third = (i+1) % 3 == 0
    line1 += ".{}..".format("*" if third else "#")
    line2 += "{symb}.{symb}.".format(symb = "*" if third else "#")
    if third:
        line3 = line3[:-1] + "*.{}.*".format(word[i])
    else: 
        line3 += ".{}.#".format(word[i])

print(line1)
print(line2)
print(line3)
print(line2)
print(line1)
