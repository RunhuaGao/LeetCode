class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        self.res = []
        self.dfs(root,0)
        return self.res
    def dfs(self,node,level):
        if node:
            if level == len(self.res):
                self.res.append([])
            self.res[level].append(node.val)
            self.dfs(node.left,level+1)
            self.dfs(node.right,level+1)
