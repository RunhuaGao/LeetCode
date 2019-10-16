class Solution {
    public boolean find132pattern(int[] nums) {
        final int size = nums.length;
        if(size < 3) return false;
        Stack<Integer> stack = new Stack<>();
        final int[] min = new int[size];
        min[0] = nums[0];
        for(int i = 1;i<size;i++) min[i] = Math.min(min[i-1],nums[i]);
        for(int i = size-1; i>=0;i--){
            if(nums[i] > min[i]){
                while(stack.size() > 0 && stack.peek()<=min[i]) stack.pop();
                if(stack.size() > 0 && stack.peek() < nums[i]) return true;
                stack.push(nums[i]);
            }
        }
        return false;
    }
    
    //Time Complexity: O(n)
    //Space Complexity: O(n)
    //Min array maintain the minnimum value up to current value(from left to right)
    //Scan the origin array from right to left and check the pattern num[j] > stack.peek() > min[j]
    //Update the stack to pop all elements that are less or equal to min[j](make sure the 1 < 3, current value is 2)
}
