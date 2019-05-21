class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        if not nums:
            return 0
        maxproduct = nums[0]
        minproduct = nums[0]
        result = nums[0]
        index = 1
        while index < len(nums):
            num = nums[index]
            if num < 0:
                maxproduct,minproduct = minproduct,maxproduct
            maxproduct = max([num,maxproduct*num])
            minproduct = min([num,minproduct*num])
            result = max([result,maxproduct])
            index+=1
        return result     
