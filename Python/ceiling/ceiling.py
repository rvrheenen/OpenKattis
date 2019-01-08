class TreeNode:
    def __init__(self, val=None):
        self.val = val
        self.left = None
        self.right = None

    def add(self, val):
        if self.val == None:
            self.val = val
        elif val < self.val:
            if self.left == None:
                self.left = TreeNode(val)
            else:
                self.left.add(val)
        else:
            if self.right == None:
                self.right = TreeNode(val)
            else:
                self.right.add(val)

def main():
    n_prototypes, n_layers = [int(x) for x in input().split()]
    shapes = set()
    for _ in range(n_prototypes):
        tree = TreeNode()
        for val in [int(x) for x in input().split()]:
            tree.add(val)
        q = [tree]
        string = ""
        while len(q) > 0:
            node = q.pop(0)
            string += "l" if node.left else "n"
            string += "r" if node.right else "n"
            if node.left:
                q.append(node.left)
            if node.right:
                q.append(node.right)
        shapes.add(string)
    print(len(shapes))




if __name__ == '__main__':
    main()
