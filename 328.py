class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def oddEvenList(self, head: ListNode) -> ListNode:
        if head is None:
            return head
        odd, even = head, head.next  # maintain the head and tail for even,odd nodes
        evenHead = even
        while even and even.next:
            odd.next = even.next
            odd = odd.next
            even.next = odd.next
            even = even.next
        odd.next = evenHead
        return head

    def construct(self, head: list) -> ListNode:
        tail = ListNode(None)
        pointer = tail
        for i in head:
            pointer.next = ListNode(i)
            pointer = pointer.next
        return tail.next
