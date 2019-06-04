class Solution {
    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        if(size <= 1) return size; // corner case: empty array || one element array
        int[] result = new int[size];
        Arrays.fill(result,1); // fill： initialize the array
        int res = 1;
        for(int curr = 0;curr < size;curr++){
            for(int start = 0;start < curr;start++){
                if(nums[curr] > nums[start]){
                    result[curr] = Math.max(result[start]+1,result[curr]);
                    res = Math.max(res,result[curr]);
                }
            }
        }
        return res;
    }
}
