# Author: Runhua
# Date: 05/20/2019
class Solution:
    def splitArray(self, nums: List[int], m: int) -> int:
        lower_bound,upper_bound = max(nums),sum(nums)+1
        while lower_bound < upper_bound:
            limit = (lower_bound+upper_bound)//2
            curr_group = self.minGroup(nums,limit)
            if curr_group > m:
                lower_bound = limit + 1
            else:
                upper_bound = limit
        return lower_bound
    
    
    def minGroup(self,nums,limit):
        group_num = 1
        curr_sum = 0
        for num in nums:
            if curr_sum+num > limit:
                group_num+=1
                curr_sum = num
            else:
                curr_sum+=num
        return group_num
