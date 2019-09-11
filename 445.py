# Definition for singly-linked list.
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        l1_reverse = self.reverseLinkedList(l1)
        l2_reverse = self.reverseLinkedList(l2)
        p1, p2 = l1_reverse, l2_reverse
        res = ListNode(None)
        res_p = res
        carry = 0
        while p1 or p2:
            v1 = p1.val if p1 else 0
            v2 = p2.val if p2 else 0
            summation = (v1 + v2 + carry) % 10
            carry = (v1 + v2 + carry) // 10
            res_p.next = ListNode(summation)
            res_p = res_p.next
            if p1: p1 = p1.next
            if p2: p2 = p2.next
        if carry > 0:
            res_p.next = ListNode(carry)
        return self.reverseLinkedList(res.next)

    def reverseLinkedList(self, l1: ListNode) -> ListNode:
        if not l1 or not l1.next:
            return l1
        pointer1, pointer2 = l1, l1.next
        while pointer1 and pointer2:
            temp = pointer2.next
            pointer2.next = pointer1
            pointer2, pointer1 = temp, pointer2
        l1.next = None
        return pointer1
