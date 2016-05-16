print("answers = {")
K = 45
screen = "A"
for i in range(K):
    screen = screen.replace("A", "X")
    screen = screen.replace("B", "BA")
    screen = screen.replace("X", "B")
    print("%d: [%d, %d]%s" % (i+1,screen.count("A"), screen.count("B"), ("," if i+1 < K else "\n}") ) )