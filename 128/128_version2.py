# version 2: memory & cache
class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # corner case: empty input array
        if not nums:
            return 0
        max_len = 1
        options = {}
        max_num,min_num = max(nums),min(nums)
        for n in nums:
            left,right = n,n
            to_update = []
            while left >= min_num and left-1 in options:
                to_update.append(left-1)
                left = options[left-1][0]
            while right <= max_num and right+1 in options:
                to_update.append(right+1)
                right = options[right+1][1]
            if left!=right:
                max_len = max([max_len,right-left+1])
                for i in to_update:
                    options[i][0] = min([left,options[i][0]])
                    options[i][1] = max([right,options[i][1]])
            options[n] = [left,right]
        return max_len
