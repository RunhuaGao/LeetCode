/**
Author: Runhua
Date: 05/20/2019
*/
class Solution {
    private int[] nums;
    public int splitArray(int[] nums, int m) {
        this.nums = nums;
        long lowerBound = getMax(nums),upperBound = getSum(nums)+1;
        while(lowerBound < upperBound){
            long limit = (lowerBound+upperBound)/2;
            int currGroup = minGroup(limit);
            if(currGroup > m) lowerBound = limit+1;
            else upperBound = limit;
        }
        return (int) lowerBound;
    }
    
    private int minGroup(long limit){
        int currSum = 0,groupNum=1;
        for(int n:nums){
            if(currSum+n > limit){
                groupNum++;
                currSum = n;
            } else{
                currSum+=n;
            }
        }
        return groupNum;
    }
    
    
    private int getMax(int[] nums){
        int result = Integer.MIN_VALUE;
        for(int n:nums) result = Math.max(result,n);
        return result;
    }
    
    private long getSum(int[] nums){
        long result = 0;
        for(int n:nums) result+=n;
        return result;
    }
}
