# version 3: set & casr about initial number
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
        nums = set(nums)
        for i in nums:
            if i-1 not in nums:
                current_num = i
                current_len = 1
                while current_num + 1 in nums:
                    current_num+=1
                    current_len+=1
                max_len = max([max_len,current_len])
        return max_len
