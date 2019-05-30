class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root,0);
        return res;
    }
    
    private void dfs(TreeNode node,int level){
        if(node!=null){
            if(level==res.size()) res.add(new ArrayList<>());
            res.get(level).add(node.val);
            dfs(node.left,level+1);
            dfs(node.right,level+1);
        }
    }
}
