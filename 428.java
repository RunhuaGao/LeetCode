//idea: serialize n ary to the structure: val,size [children](including the size of its children,make the deserializer work more effieicently)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {
    private static String start = "[";
    private static String end = "]";
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        List<String> nodes = new ArrayList<>();
        serializerHelper(root,nodes);
        return String.join(",",nodes);
    }
    
    private void serializerHelper(Node node,List<String> nodes){
        if(node==null) return;
        nodes.add(String.valueOf(node.val));
        nodes.add(String.valueOf(node.children.size()));
        for(Node child:node.children){
            serializerHelper(child,nodes);
        }
    }

    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
       if(data.isEmpty()) return null;
        String[] dataPoints = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(dataPoints));
        return deserializerHelper(queue);
    }
    
    private Node deserializerHelper(Queue<String> queue){
        int value = Integer.parseInt(queue.poll()),size = Integer.parseInt(queue.poll());
        Node root = new Node(value,new ArrayList<Node>());
        for(int i = 0;i<size;i++){
            root.children.add(deserializerHelper(queue));
        }
        return root;
    }
}
// time complexity: O(n)
// space complexity: O(n)
