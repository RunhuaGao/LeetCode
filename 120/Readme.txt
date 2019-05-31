Solution Analysis:
This is a typical dynamic progamming problem
The transformation function is:
sum(i,j) = min(sum(i-1,j-1),sum(i-1,j)
tip: check the corner case(if j>=1 and)

Two dimensional dp:
follow the transformation equation
Time complexity: O(n^2)
Space Complexity: O(n^2)

One dimensional dp:
initial array with size(n:the maximum column size), default value is Integer.MAX_VALUE
one tip: if we update the array from 0 to n(level), as each level depends on i & i-1
the future update operations will not go correctly
in this case, we should update the array from back end(for example, at level 2, start from index 2 move backward)

Time Complexity: O(n^2)
Space Complexity: O(n)
