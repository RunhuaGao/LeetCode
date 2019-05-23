Solution Analysis:

Transformation equation:
G(n) = min(G(n-1*1)+1,G(n-2*2)+1, ....) if G-i*i >=0

Time Complexity: O(n*sqrt(n))
Space Complexity: O(n)
