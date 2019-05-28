class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums.length==0) return 0;
        int cNum = 0,cSum = 0;
        HashMap<Integer,Integer> cache = new HashMap<>();
        cache.put(0,1);
        for(int n:nums){
            cSum+=n;
            if(cache.containsKey(cSum-k)) cNum+=cache.get(cSum-k);
            if(cache.containsKey(cSum)) cache.put(cSum,cache.get(cSum)+1);
            else cache.put(cSum,1);
        }
        return cNum;
    }
}
