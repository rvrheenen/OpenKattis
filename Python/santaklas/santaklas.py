import math

inp = [int(x) for x in input().split()]
if inp[1] > 180 and inp[1] < 360:
    print(abs(int(inp[0] / math.sin(math.radians(int(inp[1]))))))
else:
    print("safe")