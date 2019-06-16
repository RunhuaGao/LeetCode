/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        dfs(root,0);
        return res;
    }
    
    private void dfs(TreeNode node,int level){
        if(node!=null){
            if(level==res.size()) res.add(node.val);
            res.set(level,node.val);
            dfs(node.left,level+1);
            dfs(node.right,level+1);
        }
    }
}
