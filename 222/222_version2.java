class Solution {
    public int countNodes(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftHeight = getHeightIter(root.left),rightHeight = getHeightIter(root.right);
        if(leftHeight==rightHeight){
            // In this condition, the left tree must be a Full binary tree as rightTree must be a complete binary tree
            return (1<<leftHeight)+countNodes(root.right);
        } else {
            // In this condition the left tree must be a full binary tree as rightTree must be a complete binary tree
            return (1<<rightHeight)+countNodes(root.left);
        }
    }

    /** Get the height of a tree iteratively*/
    private int getHeightIter(TreeNode root){
        int height = 0;
        while(root!=null){
            height+=1;
            root = root.left;
        }
        return height;
    }
    /** Get the height of a tree recursively*/
    private int getHeightRecur(TreeNode root){
        if(root==null) return 0;
        return 1+getHeightRecur(root.left);
    }
}