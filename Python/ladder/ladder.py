import math

o, x = [float(x) for x in input().split(" ")]
print(math.ceil(o / math.sin(math.radians(x))))
