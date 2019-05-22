Solution Analysis:

Solution 1: Sort & Find
This method is straight forward that firstly sort the input number array
Then just compare each neighbor two elements, if find at least one of them is larger than one and the distance is larger than
1, return the result
However there exists some corner case: 
[1] the minimum element is larger than 1, directly return 1
[2] the maximum element is less than 1, directly return 1

This is such a easy method so I will not spend too much time on it
Time Complexity: O(nlogn)(sorting operation)
Space Complexity: O(1)

--------------------------------------------------------------------
Solution 2: Partition & hashcode
For the array problem,it is a cute method to use the index<->value as a hashcode to store some information
In this method, the first step it to partition the numbers array, assign all positive at the left side then return
the number of positive element
In this case, for example, we have k positive number, then the first missing number must be in range[1,k+1]
This is could be proved by math, the corner situation is that these k positive elements is just the 1 from k
then the first element is k+1
if one of them is not in [1,k] or there exists some repeat elements, the first missing must exists in [1,k+1]

But how would we store this information thourgh the array itself?
The answer is to use the hashcode(number array'index) as a information
as we already know the first k elements are positive, inorder to not interuupt the array
for example, we use the nums[0] to stands for if number "1" exists by assigning the nums[0] a negative number

Then scan the number array again(first k elements), if we find nums[index] > 0, then stands for index+1 number do not exist
if all number exists(that is the corner case we have discussed, these k elements are just 1 to k)
then we should return k+1(this could be proved by math, do not discuss here)

Time Complexity: O(n)(scan multiple times, but all operations is in linear time)
Space Complexity: O(1)
