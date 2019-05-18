For this problem, there should be some general point about binary tree we should know

First we must be clear of thee definition of two types of binary tree:

Full binary tree: each level does not have empty slots 

Complete binary tree: each level may have empty slots but the nodes will be assigned as left as possible

The number of nodes of a full binary tree equals 2**height-1

For this problem, we first must figure out the height of a complete binary tree, but according to attribute of complete binary tree
we should mode as left as possibile instead of the max(left,right)

The solution is: calculate the height of the left subtree and right subtree
If these two heights equal, then the left tree is a
full binary tree and right tree is a complete binary tree.
return 2**leftheight-1 + 1 + countNodes(root.right)

else, the right tree must be a full binary tree(rightHeight = leftHeight-1)
the left subtree must be a complete binary tree
return 2**rightheight - 1 + 1 + countNodes(root.left)

Tips: 1<<<height also do the calculation for 2**height,but run much faster with a bit operation

Time Complexity: O(logn**2)
Space Complexity: O(1)
