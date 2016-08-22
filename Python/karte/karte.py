counted = {'P': 0, 'K': 0, 'H': 0, 'T': 0}
inp = input()
cards = sorted([inp[i:i+3] for i in range(0, len(inp), 3)])

for i in range(len(cards)):
    if i > 0:
        if cards[i] == cards[i-1]:
            print("GRESKA")
            raise SystemExit            
    counted[cards[i][0]] += 1

print( " ".join([str(13 - int(x)) for x in [counted[c] for c in ['P', 'K', 'H', 'T'] ] ] ) ) 