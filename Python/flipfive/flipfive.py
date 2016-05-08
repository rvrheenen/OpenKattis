#Works but not fast enough
from collections import deque

BLACK = "*"
WHITE = "."
TOGGLES = {0:"013", 1:"0124", 2:"125", 3:"0346", 4:"13457", 5:"2458", 6:"367", 7:"6478", 8:"578"}

class Node:
    def __init__(self, grid, depth):
        self.content = grid[:]
        self.childeren = []
        self.depth = depth 

    def __repr__(self):
        return "content:\n" + self.f_grid() + "depth: " +str(self.depth) + "\nchilderen:\n" + self.f_childeren()

    def make_childeren(self):
        for i in range(9):
            self.childeren.append(Node(mutate_grid(self.content, i), self.depth+1))

    def equals(self, grid):
        return self.content == grid

    def f_grid(self):
        g = ""
        for i in range(3):
            g += "".join(["1" if x == "*" else "0" for x in self.content[3*i:3*(i+1)]] ) + "\n"
        return g

    def f_childeren(self):
        g = ""
        for i in range(3):
            for j in range(9):
                g += "".join(["1" if x == "*" else "0" for x in self.childeren[j].content[3*i:3*(i+1)]] ) + " "
            g += "\n"
        return g

def bfs(grid, node):
    q = deque()
    q.append(node)
    count = 0
    while q:
        count += 1
        node = q.popleft()
        if node.equals(grid):
            return node.depth
        node.make_childeren()
        for child in node.childeren:
            q.append(child)

def mutate_grid(grid, square_to_mutate):
    new_grid = list(grid)
    for cell in [int(c) for c in TOGGLES.get(square_to_mutate)]:
        new_grid[cell] = BLACK if grid[cell] == WHITE else WHITE
    return new_grid

P = int(input())

for i in range(P):
    grid = []
    for j in range(3):
        grid += [x for x in input()]
    root = Node(". . . . . . . . .".split(), 0)
    print(bfs(grid, root))
