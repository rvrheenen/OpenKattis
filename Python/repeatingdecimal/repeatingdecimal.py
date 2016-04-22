from decimal import localcontext, Decimal
from fractions import Fraction

def format_fraction(a, b, c):
    f = Fraction(a, b)
    with localcontext() as ctx:
        ctx.prec = c
        ctx.rounding = "ROUND_FLOOR"
        return str(Decimal(f.numerator) / f.denominator)

while(True):
    try:
        a,b,c = [int(i) for i in input().split()]
        ans = format_fraction(a,b,c)
        print(ans + "0"*(c+2-len(ans)))
    except EOFError:
        break
    