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
    private TreeNode res = null;
    private TreeNode target;
    private TreeNode pre = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p.right!=null){
            System.out.println("Situation 1");
            TreeNode pointer = p.right;
            while(pointer.left!=null) pointer = pointer.left;
            return pointer;
        } else {
            target = p;
            dfs(root);
            return res;
        }
    }
    
    private void dfs(TreeNode node){
        if(node!=null){
            dfs(node.left);
            if(pre==target && res==null){
                res = node;
                return;
            } else{
                pre = node;
            }
            dfs(node.right);
        }
    }
