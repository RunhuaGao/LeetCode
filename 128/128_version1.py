# version 1: sort&dynamic programming
class Solution(object):
    def longestConsecutive(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        # corner case: empty input array
        if not nums:
            return 0
        nums = sorted(nums)
        max_len = 1
        start = 0
        while start < len(nums):
            end = start + 1
            while end < len(nums) and nums[end]-nums[end-1]==1:
                end+=1
            max_len = max([max_len,end-start])
            start = end
        return max_len
