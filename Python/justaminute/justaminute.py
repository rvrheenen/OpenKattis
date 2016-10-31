nTrains = int(input())
predicted = 0
actual = 0
for i in range(nTrains):
    obeservation = [int(x) for x in input().split()]
    predicted += obeservation[0] * 60
    actual += obeservation[1]
result = (actual/predicted)
if result > 1:
    print("%.9f" % (result))
else:
    print("measurement error")