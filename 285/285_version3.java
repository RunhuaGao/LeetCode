class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p.right!=null){
            TreeNode pointer = p.right;
            while(pointer.left!=null) pointer = pointer.left;
            return pointer;
        } else {
            TreeNode res = null;
            while(root!=p){
                if(root.val<p.val) root = root.right;
                else{
                    res = root;
                    root = root.left;
                }
            }
            return res;
        }
    }
