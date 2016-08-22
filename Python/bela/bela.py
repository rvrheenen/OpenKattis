score_regular = {'A': 11, 'K': 4, 'Q': 3, 'J': 2, 'T': 10, '9': 0, '8': 0, '7': 0}
score_trump = {'A': 11, 'K': 4, 'Q': 3, 'J': 20, 'T': 10, '9': 14, '8': 0, '7': 0}

inp = input().split()
hands = int(inp[0])
trump_suite = inp[1]

score = 0
for i in range(4*hands):
    hand = input()
    score += score_trump[hand[0]] if hand[1] == trump_suite else score_regular[hand[0]]
print(score)