Solution 1: Sort and Two pointer find
It is so easy that do not need to talk about details of this method
Time Complexity: O(nlogn)
Space Complexity: O(1)


Solution 2: Cache and dual directions update
Establish a cache to store each number's left and right limitation
extend current number's length with dual direction, if search some number already in cache, jump to the new position
Time Complexity: O(n)
Space Complexity: O(n)

Solution 3:(Best solution)
As each consecutive sequence is unique, in this case, we do not care the dual direction
instead, we only care about the initial number for each sequence
for number we test if it is the initial number in of a potential sequence, if it is, then move forward one by one
else: do jump
cache is the set to make sure the query option is constant time
Time Complexity: O(n)
Space Complexity: O(n)
