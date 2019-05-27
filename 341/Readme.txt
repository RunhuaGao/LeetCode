Solution Analysis:

Solution one: 
Generallly flatten the array then iterate the array(Recursively flatten)
Time Complexity: O(N)
Space Complexity: O(N)
N: total number of Integers stored in the List[NestedInteger]

------------------------------------------------------------

Solution Two:
Flatten the array with [Stack]
push all NestedInteger in the origin list into stack in reverse order(keep the top element is the first element)
In hasNext() method: if stack is not empty, clarify the top element if is integer(i.isInteger())
if it is, directly return true
if it is not, then for each NestedInteger in i.getList(), push it into stack
Tip: Here reminds me of what happened during the facebook interview(use JavaScricpt to flatten an array)
each step above(for each element in the NestInteger push into the stack) is to decrease the depth of this NestedList by one
Time Complexity: O(max(depth))
Space Complexity: O(1)
