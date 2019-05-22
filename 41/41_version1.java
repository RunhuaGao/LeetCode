// version 2: partition & hashcode
class Solution {
    private static int DEFAULTANS = 1;
    public int firstMissingPositive(int[] nums) {
        int posNum = partition(nums) + 1;
        if(posNum==0) return DEFAULTANS;
        int index = 0;
        while(index < posNum){
            int value = Math.abs(nums[index]);
            if(value<=posNum && nums[value-1] > 0) nums[value-1] = -nums[value-1];
            index+=1;
        }
        index = 0;
        while(index < posNum){
            if(nums[index] > 0) return index+1;
            index+=1;
        }
        return posNum+1;
    }
    
    private int partition(int[] nums){
        int index = 0;
        int position = -1;
        while(index < nums.length){
            if(nums[index] > 0){
                position+=1;
                swap(nums,position,index);
            }
            index+=1;
        }
        return position;
    }
    
    private void swap(int[] nums,int index1,int index2){
        if(index1!=index2){
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }
    }
}
