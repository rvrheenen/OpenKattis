alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_."

while (True):
    inp = input().split()
    rotation = int(inp[0])
    if rotation == 0:
        break

    line = inp[1][::-1]
    line = "".join([alphabet[(alphabet.find(letter) + rotation) % len(alphabet)] for letter in line])
    print(line)
