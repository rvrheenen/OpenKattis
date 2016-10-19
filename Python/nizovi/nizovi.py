line = input()
spaces = 0
elements = 0
for i in range(len(line)):
    char = line[i]
    if char == "{":
        elements = 0
        print(spaces * " " + char)
        spaces += 2
    elif char == "}":
        spaces -= 2
        print(("\n" if elements > 0 else "") + spaces * " " + char, end=("" if (spaces > 0 and line[i+1] == ",") else "\n"))
        elements = 0
    elif char == ",":
        elements = 0
        print(char)
        pass
    else:
        if elements == 0:
            print(spaces * " ", end="")
        elements += 1
        print(char, end="")