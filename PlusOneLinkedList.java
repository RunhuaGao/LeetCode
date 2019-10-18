
public class PlusOneLinkedList {
    public ListNode plusOneList(ListNode head) {
        ListNode currNode = head, right = null;
        // find the last non-9 digit from right side
        while (currNode != null) {
            if (currNode.val != 9) right = currNode;
            currNode = currNode.next;
        }
        // if right is null, means that all digits in list is 9
        // add 1 at the head of list
        if (right==null){
            right = new ListNode(0);
            right.next = head;
            head = right;
        }
        right.val++;
        currNode = right.next;
        // reset all value that before right to zero(all digits after node right is 9)
        while (currNode!=null){
            currNode.val = 0;
            currNode = currNode.next;
        }
        return head;
    }
}

// Time Complexity: O(n)
// Space Complexity: O(1)

