class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();
        queue.offer(root);
        levelQueue.offer(0);
        while(queue.size() > 0){
            TreeNode curr = queue.poll();
            int level = levelQueue.poll();
            if(curr!=null){
                if(res.size()==level) res.add(new ArrayList<>());
                res.get(level).add(curr.val);
                queue.offer(curr.left);levelQueue.offer(level+1);
                queue.offer(curr.right);levelQueue.offer(level+1);
            }
        }
        return res;
    }
}
