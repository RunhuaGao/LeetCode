class Solution(object):
    def subarraySum(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        if len(nums) == 0:
            return 0
        dic = {}
        dic[0] = 1
        csum,cnt = 0,0
        for n in nums:
            csum+=n
            cnt+=dic.get(csum-k,0)
            dic[csum] = dic.get(csum,0)+1
        return cnt
