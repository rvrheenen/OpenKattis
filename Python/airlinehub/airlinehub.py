class Airport:
    def __init__(self, xy):
        self.x = xy[0]
        self.y = xy[1]

    def __repr__(self):
        return "%.2f, %.2f" % (self.x, self.y)

airports = []
while(True):
    try:
        n = int(input())
        for i in range(n):
            airports.append(Airport([float(x) for x in input().split()]))
    except EOFError:
        break

    #calculate the distance