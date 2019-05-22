Mathematical proof:
Dynammic Programming:
Transformation equation:
numTrees(n) = F(i,n) i starts from 1 to n
// F(i,n) stands for that use i as the root use n elements
F(i,n) = G(i-1) * G(n-i)

Time complexity: O(n*n)
Space complexity: O(n)
