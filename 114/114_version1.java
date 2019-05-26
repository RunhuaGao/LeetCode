class Solution {
    public void flatten(TreeNode root) {
        if(root!=null){
            flatten(root.left);
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            TreeNode pointer = root;
            while(pointer.right!=null) pointer = pointer.right;
            flatten(temp);
            pointer.right = temp;
        }
    }
}
