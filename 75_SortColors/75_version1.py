class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        size = len(nums)
        if size < 2:return
        red,white,blue = 0,0,0
        for n in nums:
            if n==0:red+=1
            elif n==1:white+=1
            else:blue+=1
        threshold_red = red
        threshold_white = red+white
        for i in range(size):
            if i < threshold_red:nums[i] = 0
            elif i < threshold_white:nums[i] = 1
            else:nums[i] = 2
# Straight Forward Two pass algorithm
# Iterate the array first, count the number of red,white,red
# Then directly overwrite the array
