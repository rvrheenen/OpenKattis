a = int(input())
b = int(input())
if (b - a) > 180:
    print(b - a - 360)
elif (b - a) > -180:
    print(b - a)
else:
    print(b - a + 360)