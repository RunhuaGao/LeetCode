"""
Problem Description:
One dimensional candy crush problem
"""


class Solution:
    def crush(self, state: list):
        stack = []
        conti = 0
        for i in state:
            if not stack or i == stack[-1]:
                conti += 1
            else:
                if conti >= 3:
                    while conti > 0:
                        stack.pop()
                        conti -= 1
                conti = 1
            stack.append(i)
            print(stack)
        if conti >= 3:
            while conti > 0:
                stack.pop()
                conti -= 1
        print(stack)
        return stack


test = [1, 2, 2, 2, 2, 2, 2, 3, 3, 4, 4, 4]
Solution().crush(test)

"""
Solution Analysis:
Use stack and record the continue number(must be larger than 3 to remove same neighbor numbers)
Time Complexity: O(n)
Space Complexity: O(n)
"""
