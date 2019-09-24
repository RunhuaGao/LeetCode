/**
idea: binary search
little trick: the total missing number at index is nums[index]-nums[0]-index(could be proved by math, such an awesome solution!)
could use the little trick above to implement binary search in the array,
according to comparison between the accumulate missing number and k
*/

class Solution {
    int initial;
    int[] nums;
    public int missingElement(int[] nums, int k) {
        //corner case: if k > accumulate number of missing number between 0 and length-1, extend the answer
        initial = nums[0];this.nums = nums;
        int size = nums.length;
        if(k > missingNumber(size-1)) return nums[size-1]+k-missingNumber(size-1);
        int left = 0,right=size-1,mid;
        while(left < right){
            mid = left + (right-left)/2;
            if(missingNumber(mid)<k) left = mid+1;
            else right = mid;
        }
        return nums[left-1]+k-missingNumber(left-1);
    }
    
    
    private int missingNumber(final int index) {return nums[index]-initial-index;}
}

// Time Complexity: O(lgn)
// Space Complexity: O(1)
