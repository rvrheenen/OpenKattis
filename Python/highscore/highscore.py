import math
letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

def get_dist(f, t):
    f = letters.find(f)
    t = letters.find(t)
    dist = abs(f-t)
    return (dist if dist<=13 else 26-dist)

def find_nearest(screen, name, current, right_first):
    if screen[current] != name[current]:
        return current, 0
    right = current
    left = current
    for i in range(math.ceil(len(screen))):
        right = right + 1 if right  < len(screen) - 1 else 0
        left = left - 1 if left > 0 else len(screen) - 1
        if right_first:
            if screen[right] != name[right]:
                return right, i+1
        if screen[left] != name[left]:
            return left, i+1
        if screen[right] != name[right]:
            return right, i+1
    return None, None

N = int(input())
for i in range(N):
    name = [i for i in input()]
    count = [0,0]
    for i in range(2):
        screen = [x for x in "A"*len(name)]
        current = 0
        while(screen != name):
            current, dist = find_nearest(screen, name, current, i==0)
            count[i] += dist
            count[i] += get_dist(screen[current], name[current])
            screen[current] = name[current]
    print(min(count))