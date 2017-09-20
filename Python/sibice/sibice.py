import math

matches, width, height = [int(x) for x in input().split()]

print( "\n".join(["DA" if fits else "NE" for fits in [int(input()) <= math.sqrt(width**2 + height**2) for _ in range(matches)]]) )