# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution:
    def countNodes(self, root: TreeNode) -> int:
        """
        :param root: the input complete binary tree
        :return: number of nodes of the tree
        """
        if not root:
            return 0
        return 1 + self.countNodes(root.left) + self.countNodes(root.right)
