firstCase = True
while(True):
    nLines = int(input())
    if nLines == 0:
        break
    if firstCase:
        firstCase = False
    else:
        print()
    line_length = 0
    lines_legit = True
    for i in range(nLines):
        line = input().split()
        pixel = line[0]
        pixel_lengths = [int(x) for x in line[1:]]
        for seq in pixel_lengths:
            print(pixel*seq, end="")
            pixel = "#" if pixel == "." else "."
        print()
        if lines_legit:
            if sum(pixel_lengths) != line_length:
                if line_length != 0:
                    lines_legit = False
                line_length = sum(pixel_lengths)
    if not lines_legit:
        print("Error decoding image")