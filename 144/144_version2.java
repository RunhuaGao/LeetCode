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
        Stack<TreeNode> stack = new Stack<>();
        if(root==null) return res;
        stack.push(root);
        while(!stack.empty()){
            TreeNode curr = stack.pop();
            res.add(curr.val);
            if(curr.right!=null) stack.push(curr.right);
            if(curr.left!=null) stack.push(curr.left);
        }
        return res;
    }
