cards = input()
scores = {'T':0, 'C':0, 'G':0}
for card in cards:
    scores[card] += 1
print(sum([ x**2 for x in scores.values()]) + 7 * min(scores.values()))