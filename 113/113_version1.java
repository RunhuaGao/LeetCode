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
    private List<List<Integer>> res = new ArrayList<>();
    private int target;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        this.target = sum;
        dfs(root,0,new ArrayList<>());
        return res;
    }
    
    private void dfs(TreeNode node,int currSum,List<Integer> pathRecord){
        if(node!=null){
            pathRecord.add(node.val);
            if(node.left==null && node.right==null){
                if(currSum+node.val==target){
                    res.add(new ArrayList<>(pathRecord));
                }
            } else {
                dfs(node.left,currSum+node.val,pathRecord);
                dfs(node.right,currSum+node.val,pathRecord);
            }
            pathRecord.remove(pathRecord.size()-1);
        }
    }
}
