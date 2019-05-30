class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        queue = []
        res = []
        queue.append([0,root])
        while queue:
            level,node = queue.pop()
            if node:
                if level == len(res):
                    res.append([])
                res[level].append(node.val)
                queue.insert(0,[level+1,node.left])
                queue.insert(0,[level+1,node.right])
        return res
