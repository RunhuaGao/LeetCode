class Solution:
    def flatten(self, root: TreeNode) -> None:
        """
        Do not return anything, modify root in-place instead.
        """
        if root:
            self.flatten(root.left)
            temp = root.right
            root.right = root.left
            self.flatten(temp)
            pointer = root
            while pointer.right:
                pointer = pointer.right
            pointer.right = temp
            root.left = None
