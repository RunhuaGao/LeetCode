// brute force
// calculate the missing number between each two neighbor numbers(accmulate summation)
class Solution {
    public int missingElement(int[] nums, int k) {
        int missing = 0;
        int index = 0;
        boolean inRange = false;
        for(index = 1;index<nums.length;index++){
            missing+=nums[index]-nums[index-1]-1;
            if(missing>=k){
                inRange = true;break;
            }
        }
        if(inRange){
            int initial = nums[index]-1;
            while(missing>k){
                missing--;initial--;
            }
            return initial;
        } else {
            return nums[index-1] + k-missing;
        }
        
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)
