ups = [x=="U" for x in input()]
isUp = ups[0]
a = 0
b = 0
c = 0
#always up
for i in ups[1:len(ups)]:
    if isUp:
        if not i:
            a += 2
    else:
        a += 1
        isUp = True

#always down
isUp = ups[0]
for i in ups[1:len(ups)]:
    if isUp:
        b += 1
        isUp = False
    else:
        if i:
            b += 2

#as you wish
isUp = ups[0]        
for i in ups[1:len(ups)]:
    if isUp and not i:
        isUp = False
        c += 1
    elif not isUp and i:
        isUp = True
        c += 1

print(a)
print(b)
print(c)