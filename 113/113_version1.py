# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def pathSum(self, root: TreeNode, sum: int) -> List[List[int]]:
        self.target = sum
        self.res = []
        self.dfs(root,0,[])
        return self.res
    def dfs(self,node,curr_sum,path_record):
        if node:
            path_record.append(node.val)
            if not node.right and not node.left:
                if curr_sum+node.val == self.target: # is leaf node
                    self.res.append([i for i in path_record])
            else:
                self.dfs(node.left,curr_sum+node.val,path_record)
                self.dfs(node.right,curr_sum+node.val,path_record)
            path_record.pop()
