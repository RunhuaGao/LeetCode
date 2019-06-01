class Solution:
    def generateTrees(self, n: int) -> List[TreeNode]:
        if n==0:return []
        return self.helper(1,n)
    
    
    def helper(self,start,end):
        if start > end:
            return [None,]
        res = []
        for i in range(start,end+1):
            left_trees = self.helper(start,i-1)
            right_trees = self.helper(i+1,end)
            for l in left_trees:
                for r in right_trees:
                    root = TreeNode(i)
                    root.left = l
                    root.right = r
                    res.append(root)
        return res
