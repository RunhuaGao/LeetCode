class Solution:
    def pathInZigZagTree(self, label: int):
        # Step 1: find the level
        level = 0
        base = 2
        summation = 0
        while (summation < label):
            summation += base ** level
            level += 1
        print("Level is ", level)
        res = []
        while label > 0:
            res.append(int(label))
            if level % 2 > 0:
                label = 3 * base ** level // 2 - 1 - label
            label //= 2
            level -= 1
        return res[::-1]


Solution().pathInZigZagTree(14)
