class Solution {
    private int res = Integer.MAX_VALUE;;
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        dfs(root,1);
        return res;
    }
    
    private void dfs(TreeNode node,int level){
        if(node.left==null && node.right==null) res = Math.min(res,level);
        else{
            if(node.left!=null) dfs(node.left,level+1);
            if(node.right!=null) dfs(node.right,level+1);
        }
    }
