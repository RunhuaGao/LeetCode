class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        size = len(nums)
        if size <=1:return size # corner case, empty list or one element list
        result = [1 for _ in range(size)]
        res = 1
        curr = 0
        while curr < size:
            start = 0
            while start < curr:
                if nums[curr] > nums[start]:
                    result[curr] = max([result[start]+1,result[curr]])
                    res = max([res,result[curr]])
                start+=1
            curr+=1
        return res
