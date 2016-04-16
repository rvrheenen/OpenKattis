N = int(input())
for i in range(N):
    known_noises = []
    recording = input().split(" ")
    line = ""
    while(True):
        line = input()
        if line == "what does the fox say?":
            break
        known_noises.append(line.split(" ")[2])
    what_the_fox_says = ""
    for sound in recording:
        if sound not in known_noises:
            what_the_fox_says += sound + " "
    print(what_the_fox_says.strip())