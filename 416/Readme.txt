Also this is a dynammic programming problem
It is also a bagpack problem(get element from array and if the summation could be a specific number)
here this is the totalsum//2, also, this number could be any others
the transformation equation is similiar for the perfect square problem
use dp[i] to stand for if the number i could be reached by some numbers in array
dp[i] = or(dp[i-n] for n in nums if i-n>=0)

Time Complexity: O(sum*size)
Space Complexiy: O(sum)

Tips: we can not change the iteration order becasue: each number in the array could be only used once
If we change the iteration order， for example, the outter iteration is summation
if the array is [1,2,5]
then the first element will make each totalSum is reachable but it is to use 1 each time, this is not the case
as there is only one "1" in the array
