# version 2: partition
class Solution:
    def firstMissingPositive(self, nums: List[int]) -> int:
        # as now we have [pos_num] positive elements
        # the first missing element must exists in range[1,pos_num]
        pos_num = self.partition(nums)+1
        # corner case: there is no positive number in nums array
        if pos_num == 0:
            return 1
        
        # step 2: use nums[i] to stand for if i+1 exists(keep original information of nums)
        # i>=0 && i<k
        index = 0
        while index < pos_num:
            value = abs(nums[index])
            if value <= pos_num and nums[value-1] > 0:
                nums[value-1] = -nums[value-1]
            index+=1
        index = 0
        while index < pos_num:
            if nums[index] > 0:
                return index+1
            index+=1
        
        return pos_num+1
    
    
    def partition(self,nums):
        """
        partition the nums array, put all positive elements at the left side
        return: the end index of last positive element
        """
        index = 0
        pos=-1
        while index < len(nums):
            if nums[index] > 0:
                pos+=1
                if pos!=index:
                    nums[index],nums[pos] = nums[pos],nums[index]
            index+=1
        return pos
