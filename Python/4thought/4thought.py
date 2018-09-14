OPERATORS = ["+", "-", "*", "//"]
N = 4

def main():
    # iterate over 3-ary cartesian product of the operators, generate all equations
    equations = {}
    for op1 in OPERATORS:
        for op2 in OPERATORS:
            for op3 in OPERATORS:
                equation = "{n} {op1} {n} {op2} {n} {op3} {n}".format(n=N, op1=op1, op2=op2, op3=op3)
                equations[eval(equation)] = equation.replace("//","/") # needed for printing

    n_cases = int(input())
    for i in range(n_cases):
        num = int(input())
        if num in equations.keys():
            print("{} = {}".format(equations[num], num))
        else:
            print("no solution")

if __name__ == '__main__':
    main()
