definitions = {}
while(True):
    try:
        inp = input()
    except EOFError:
        break
    line = inp.split(" ")
    if line[0] == "def":
        definitions.update({line[1]: int(line[2])})
    elif line[0] == "clear":
        definitions.clear()
    elif line[0] == "calc":
        calc = (line[1:len(line)-1])
        total = 0
        operator = "+"
        for i in calc:
            if i == "+":
                operator = "+"
            elif i == "-":
                operator = "-"
            else:
                one_var = definitions.get(i)
                if one_var == None:
                    total = "unknown"
                    break
                else:
                    if operator == "+":
                        total += one_var
                    else:
                        total -= one_var
        total = next((k for k,v in definitions.items() if v == total), "unknown")
        print(inp[5:len(inp)] + " " + str(total))