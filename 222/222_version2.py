# Definition for a binary tree node.
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None


class Solution:
    def countNodes(self, root: TreeNode) -> int:
        """
        :param root: input tree
        :return: number of nodes in tree
        """
        # Version2: utilize the complete attribute:
        # the number of nodes is exponential to the depth of tree
        if not root:
            return 0
        left_height, right_height = Solution.get_depth_recur(root.left), Solution.get_depth_recur(root.right)
        if left_height == right_height: # The left subtree is a full binary tree and right subtree is a complete binary tree
            return (1<<left_height)+self.countNodes(root.right)
        else:
            return (1<<right_height)+self.countNodes(root.left)


    @staticmethod
    def get_depth_recur(self, root: TreeNode) -> int:
        """
        Get the height of a tree recursively
        :param root: the input tree
        :return: height of the tree
        """
        height = 0
        while root:
            height += 1
            root = root.left
        return height

    @staticmethod
    def get_depth_iter(self, root: TreeNode) -> int:
        """
        Get the height of a tree iteratively
        :param root:the input binary tree
        :return: height of the input binary tree
        """
        if root is None:
            return 0
        return 1 + self.get_depth_recur(root.left)
