names     = ["Adrian", "Bruno", "Goran"]
sequences = [ ["A", "B", "C"], ["B", "A", "B", "C"], ["C", "C", "A", "A", "B", "B"] ]
scores    = [0, 0, 0]

amount   = input()
corrects = input()

for i in range(len(corrects)):
    for j in range(3):
        if ( corrects[i] == sequences[j][i % len(sequences[j])] ):
            scores[j] += 1

highest = max(scores)

print(highest)
for i in range(3):
    if scores[i] == highest:
        print(names[i])