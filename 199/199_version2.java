class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return res;
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> levelStack = new Stack<>();
        nodeStack.push(root);levelStack.push(0);
        while(!nodeStack.empty()){
            int level = levelStack.pop();
            TreeNode curr = nodeStack.pop();
            if(level==res.size()) res.add(curr.val);
            res.set(level,curr.val);
            if(curr.right!=null){
                nodeStack.push(curr.right);
                levelStack.push(level+1);
            }
            if(curr.left!=null){
                nodeStack.push(curr.left);
                levelStack.push(level+1);
            }
        }
        return res;
    }
