# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def sortList(self, head: ListNode) -> ListNode:
        # corner case: empty list or one node list
        if head is None or head.next is None:
            return head
        # Use slow&fast pointer to cut the list into half
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next
        l1 = self.sortList(slow.next)
        slow.next = None
        l2 = self.sortList(head)
        return self.mergeTwoList(l1, l2)

    def mergeTwoList(self, l1, l2):
        res = ListNode(None)
        pointer = res
        p1, p2 = l1, l2
        while p1 or p2:
            if not p1:
                pointer.next = p2
                p2 = p2.next
            elif not p2:
                pointer.next = p1
                p1 = p1.next
            else:
                if p1.val <= p2.val:
                    pointer.next = p1
                    p1 = p1.next
                else:
                    pointer.next = p2
                    p2 = p2.next
        return pointer.next


def test():
    head = ListNode(1)
    head.next = ListNode(2)
    head.next.next = ListNode(3)
    head.next.next.next = ListNode(4)
    Solution().sortList(head)

test()
