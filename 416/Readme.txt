Also this is a dynammic programming problem
It is also a bagpack problem(get element from array and if the summation could be a specific number)
here this is the totalsum//2, also, this number could be any others
the transformation equation is similiar for the perfect square problem
use dp[i] to stand for if the number i could be reached by some numbers in array
dp[i] = or(dp[i-n] for n in nums if i-n>=0)

Time Complexity: O(sum*size)
Space Complexiy: O(sum)
