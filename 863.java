/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.HashMap;
import java.util.Map;
class Solution {
    Map<TreeNode,TreeNode> parentNode;
    Set<TreeNode> seenNodes;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        // Step 1: transform the tree to the undirected graph
        // substep1: record each node's parent node
        parentNode = new HashMap<>();
        dfs(root,null);
        // step2: initialize the bfs search in the graph from the targetNode
        seenNodes = new HashSet<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> disQueue = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        nodeQueue.add(target);disQueue.add(0);
        int distance = 0;
        while(nodeQueue.size() > 0 & distance < K+1){
            TreeNode currNode = nodeQueue.poll();
            int currDis = disQueue.poll();
            if(currDis==K) res.add(currNode.val);
            for(TreeNode node:getNeighbor(currNode)){
                nodeQueue.add(node);
                disQueue.add(currDis+1);
            }
            distance = Math.max(distance,currDis);
            seenNodes.add(currNode);
        }
        return res;
    }
    
    
    private void dfs(final TreeNode node,final TreeNode pNode){
        if(node!=null){
            parentNode.put(node,pNode);
            dfs(node.left,node);dfs(node.right,node);
        }
    }
    
    
    private List<TreeNode> getNeighbor(final TreeNode node){
        final List<TreeNode> res = new LinkedList<>();
        if(add(node.left)) res.add(node.left);
        if(add(node.right)) res.add(node.right);
        TreeNode parent = parentNode.get(node);
        if(add(parent)) res.add(parentNode.get(node));
        return res;
    }
    
    private boolean add(final TreeNode node){
        return node!=null && !seenNodes.contains(node);
    }
    
}

//Time Complexity: O(n)
//Space Complexity: O(n)
