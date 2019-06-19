The difference between 39 & 40 is that if the input candidates has repeat elements
For 39, we could use one element for multiple times
For 40, we can not.

As there is a general mode for this kind combination problem: Choose a subset from an input set
the subset should meet some condition(Such as subset's summation or length or something else)
The general mode is stored in General_mode.java file, please read it carefully

for 39, the point is that we can use one element mupltiple times, in that case, the next start index should be as same as the
previous one instead of(index+1)

for 40, as we should avoid repeating and we wanna cut some search branch, should skip the repeat elements at current level and
set nums[i] < currVal to make sure the search could continue smoothly

39:
Time Complexity: O(2^n)
Space Complexity: O(kn)

40:
Time Complexity: O(2^n)
Space Complexity: O(kn)
