// clarify: successor is after node
// inorder : left -> node -> right
// situation 1, if current node has right subtree, then the successor node is in it's right subtree: node -> right
// situation 2, current node does not have right subtree, then the successor is in upper tree, continue move right: left->node
// the current node is the last node in left subtree of target node
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/
class Solution {
    public Node inorderSuccessor(Node x) {
        // successor: after node
        // situation 1: in lower tree
        if(x.right!=null){
            x = x.right;
            while(x.left!=null) x = x.left;
            return x;
        }
        
        
        //situation 2: in upper tree
        while(x.parent!=null && x == x.parent.right) x =x.parent;
        return x.parent;
    }
}
// Time Complexity: O(logH ~ H) H: height of the tree
// Space Complexity: O(1)
