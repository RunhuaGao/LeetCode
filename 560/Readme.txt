This is a typical dynamic programming problem
Transformation equation:
number = number(currentnum-k)
go through the array, update the current summation and current Number by current Number + hashmap(current summation - k)

Time Complexity: O(n)
Space Complexity: O(n)
