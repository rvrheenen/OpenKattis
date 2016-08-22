countdown = int(3.5 * 60)
player = int(input())
N = int(input())

for i in range(N):
    question = input().split()
    countdown -= int(question[0])
    if countdown <= 0:
        break
    if question[1] == "T":
        player = player + 1 if player < 8 else 1
print(player)