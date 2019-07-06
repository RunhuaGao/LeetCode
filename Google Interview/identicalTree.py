class Node:
    def __init__(self, val=None):
        self.val = val
        self.right = self.left = None


class Solution:
    def identicalTree(self, root):
        self.res = 0
        self.order = set()
        self.recur(root)
        print(self.order)
        return self.res

    def recur(self, node):
        if node == None:
            return "", 0
        left, left_size = self.recur(node.left)
        right, right_size = self.recur(node.right)
        curr_size = left_size + 1 + right_size
        structure = left + str(node.val) + right
        if structure in self.order and curr_size > self.res:
            self.res = curr_size
        self.order.add(structure)
        return structure, curr_size


def test():
    root = Node(7)
    root.left = Node(1)
    root.right = Node(1)
    root.left.left = Node(2)
    root.right.left = Node(2)

    print(Solution().identicalTree(root))


test()
