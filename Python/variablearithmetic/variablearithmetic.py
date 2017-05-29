variables = {}
while(True):
    line = input().split()
    if line == ["0"]:
        break
        
    if "=" in line:
        variables[line[0]] = int(line[2])
    else:
        additions = [x for x in line if x != "+"]
        digits = [item for item in additions if item.isdigit()]

        undefined = [item for item in additions if item not in variables and item not in digits]
        defined = [item for item in additions if item in variables and not item in digits]
        
        calc = []
        if len(defined) > 0:
            calc = [sum([variables.get(item) for item in defined]) ]
            if len(digits) > 0:
                calc[0] += sum([int(x) for x in digits])
        else:
            if len(digits) > 0:
                calc = [sum([int(x) for x in digits])]


        print(" + ".join([str(s) for s in calc] + undefined))