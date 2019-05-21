class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0 || nums==null) return 0;
        int result = nums[0],minpro = nums[0],maxpro = nums[0];
        for(int index = 1;index < nums.length;index++){
            int value = nums[index];
            int temp = maxpro;
            maxpro = Math.max(Math.max(minpro*value,maxpro*value),value);
            minpro = Math.min(Math.min(minpro*value,temp*value),value);
            result = Math.max(maxpro,result);
        }
        return result;
    }
}
