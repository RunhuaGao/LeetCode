class Solution {
    private TreeNode ans;
    private int maxH;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        contains(root,1);
        return ans;
    }
    
    
    private int contains(TreeNode node,int level){
        maxH = Math.max(level,maxH);
        if(node==null) return level;
        int left = contains(node.left,level+1),right = contains(node.right,level+1);
        if(left==maxH && right==maxH) ans = node;
        return Math.max(left,right);
    }
    
}
// bottom-up post-order travel the tree
