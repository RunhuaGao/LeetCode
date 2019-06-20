class Solution:
    def sortColors(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        size = len(nums)
        if size < 2:return # corner case handler
        right_zero = 0
        left_two = size-1
        curr = 0
        while curr <= left_two:
            val = nums[curr]
            if val == 0:
                nums[curr],nums[right_zero] = nums[right_zero],nums[curr]
                right_zero+=1
            elif val == 2:
                nums[curr],nums[left_two] = nums[left_two],nums[curr]
                left_two-=1
            if val!=2:
                curr+=1
"""
One pass algorithm
The intuition is as same as the two pass algorithm:
make sure the boundary between zero&one one&two
Use two pointers to track the current position of these two bondarys
and iterate the array, 
if current value is 0, increase the zero&one boundary, swap current value with boundary
if current value is 1, skip
if current value is 2, decrease the one&two boundary, swap current value with boundary
"""

# Time Complexity: O(N)
# Space Complexity: O(1)
# As same as algorithm 1
