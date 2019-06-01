class Solution {
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new ArrayList<>();
        return helper(1,n);
    }
    
    private List<TreeNode> helper(int start,int end){
        List<TreeNode> res = new ArrayList<>();
        if(start > end){
            res.add(null);
            return res;
        }
        for(int i = start;i<=end;i++){
            List<TreeNode> leftTrees = helper(start,i-1);
            List<TreeNode> rightTrees = helper(i+1,end);
            for(TreeNode l:leftTrees){
                for(TreeNode r:rightTrees){
                    TreeNode root = new TreeNode(i); // New current node tree
                    root.left = l;root.right = r; // combination of all left&right subtrees
                    res.add(root);
                }
            }
        }
        return res;
    }
}
