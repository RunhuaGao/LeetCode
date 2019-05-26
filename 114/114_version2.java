class Solution {
    public void flatten(TreeNode root) {
       TreeNode current = root;
        while(current!=null){
            if(current.left!=null){
                TreeNode tempLeft = current.left;
                while(tempLeft.right!=null) tempLeft = tempLeft.right;
                tempLeft.right = current.right;
                current.right = current.left;
                current.left = null;
            }
            current = current.right;
        }
    }
}
