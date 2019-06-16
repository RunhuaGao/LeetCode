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
    private List<Integer> res = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        preOrderDfs(root);
        return res;
    }
    
    private void preOrderDfs(TreeNode node){
        if(node!=null){
            res.add(node.val);
            preOrderDfs(node.left);
            preOrderDfs(node.right);
        }
    }
