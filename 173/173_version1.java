class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        TreeNode pointer = root;
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }
    
    /** @return the next smallest number */
    public int next() {
        int val = stack.peek().val;
        TreeNode curr = stack.pop();
        curr = curr.right;
        while(curr!=null){
            stack.push(curr);
            curr = curr.left;
        }
        return val;
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size() > 0;
    }
}

