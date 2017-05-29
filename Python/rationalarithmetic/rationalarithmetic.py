import operator
from fractions import Fraction

ops = {"+": operator.add,
       "-": operator.sub,
       "*": operator.mul,
       "/": operator.truediv}

num_operations = int(input())
for i in range(num_operations):
    x1, x2, operator, y1, y2 = [x if x in ops.keys() else int(x) for x in input().split()] # get input

    if operator == "/":
        tmp = y1
        y1 = y2
        y2 = tmp
        operator = "*"

    if operator == "*":
        z1 = x1 * y1
    else:
        z1 = ops[operator](x1*y2, y1*x2)
    z2 = x2 * y2

    print("{fr.numerator} /  {fr.denominator}".format(fr = Fraction(z1, z2)))