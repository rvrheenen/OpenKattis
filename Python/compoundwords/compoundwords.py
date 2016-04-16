wordsin = set()
wordsout = set()
while(True):
    try:
        inp = input().split(" ")
        for i in inp:
            wordsin.add(i)
    except EOFError:
        for i in wordsin:
            for j in wordsin:
                if i != j:
                    wordsout.add(i+j)
        for w in sorted([x for x in wordsout]):
            print(w)
        break