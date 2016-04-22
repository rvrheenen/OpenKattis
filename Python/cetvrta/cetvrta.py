x = [None] * 3
y = [None] * 3
for i in range(3):
    x[i], y[i] = [a for a in input().split()]
xa = "".join([i for i in x if x.count(i) == 1])
ya = "".join([i for i in y if y.count(i) == 1])
print("%s %s" % (xa, ya))