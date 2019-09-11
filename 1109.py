class Solution:
    def nextLargerNodes(self, head: ListNode) -> List[int]:
        elements = []
        pointer = head
        # convert the linkedlist to array
        while pointer:
            elements.append(pointer.val)
            pointer = pointer.next
        stack = []
        res = [0 for _ in range(len(elements))]
        index = 0
        while index < len(res):
            while stack and elements[stack[-1]] < elements[index]:
                res[stack.pop()] = elements[index]
            stack.append(index)
            index+=1
        return res
// should rememeber this method
// the "monotonic stack" is used for solve the problems like next greater/smaller element for both linkedlist/array
