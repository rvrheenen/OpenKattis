import resource, sys
sys.setrecursionlimit(10**6)

def remove_star(pixels, x, y):
    if pixels[x][y] == "#":
        return pixels
    pixels[x][y] = "#"
    if x > 0:
        remove_star(pixels, x - 1, y)
    if x < len(pixels) - 1:
        remove_star(pixels, x + 1, y)
    if y > 0:
        remove_star(pixels, x, y - 1)
    if y < len(pixels[0]) - 1:
        remove_star(pixels, x, y + 1)
    return pixels

case = 1
while(True):
    try:    
        dimensions = [int(x) for x in input().split()]
        pixels = []
        for x in range(dimensions[0]):
            pixels.append(list(input()))
            
        star_count = 0
        for x in range(dimensions[0]):
            for y in range(dimensions[1]):
                if pixels[x][y] == "-":
                    star_count += 1
                    pixels = remove_star(pixels, x, y)
        print("Case %d: %d" % (case, star_count))
        case += 1
    except EOFError:
        break