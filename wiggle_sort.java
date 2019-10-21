// Wiggle sort 1:
// main tain nums[0] <= nums[1] >= nums[2] <= nums[3] ....
// directly iterate the array and compare current number with its previous one
// if at even index and larger than previous one, swap them, similar for odd index 
public class Solution {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length < 2) return;
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 0 && nums[i] > nums[i - 1]) || (i % 2 == 1 && nums[i] < nums[i - 1])) {
                int tmp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = tmp;
            }
        }
    }
}


// Wiggle sort 2:
// maintain the array: nums[0] < nums[1] > nums[2] < nums[3] ...
// sort the origin array and median number of it
// then fill the array from end of first half and second half
// O(nlogn) time/O(n) space
class Solution {
    public void wiggleSort(int[] nums) {
        // solution 1: nlogn/n
        // find the median number,the pop number from first half/second half alternatively
        Arrays.sort(nums); //nlogn
        int n = nums.length;
        int k = (n+1)>>1,j=n;
        final int[] res = new int[n];//linear space
        for(int index = 0;index<n;index++){
            res[index] = (index&1)==0?nums[--k]:nums[--j];
        }
        for(int index = 0;index<n;index++) nums[index] = res[index];
    }
}
