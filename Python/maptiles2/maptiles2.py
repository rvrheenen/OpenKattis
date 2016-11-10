quadkey = input()

x = 0
y = 0
level = len(quadkey)
for i in range(level):
    let = int(quadkey[level - i -1])
    if let == 0:
        pass
    elif let == 1:
        x += int((2**(i+1))/2)
    elif let == 2:
        y += int((2**(i+1))/2)
    elif let == 3:
        x += int((2**(i+1))/2)
        y += int((2**(i+1))/2)

print(level, x, y)