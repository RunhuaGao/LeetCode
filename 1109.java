/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> elements = new ArrayList<>();
        ListNode pointer = head;
        while(pointer!=null){
            elements.add(pointer.val);
            pointer = pointer.next;
        }
        // monotonic stack
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[elements.size()];
        for(int i = 0;i<elements.size();i++){
            while(stack.size()>0 && elements.get(stack.peek()) < elements.get(i))
                res[stack.pop()] = elements.get(i);
            stack.push(i);
        }
        return res;
    }
}
