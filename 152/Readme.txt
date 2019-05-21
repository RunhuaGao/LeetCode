Solution Analysis:

This is a typical array problem(for example, we have solved a problem: fina maximum summation subarray)
However, the interesting point is that: there maybe exist negative number inside the array
The influence of negative point is that: for example, the -2,-4,-5,-6 could also produce a big subarray summation
which results that we could not only consider the positive&maximum previous production, also should take the minimum production
into consideration

This problem could also be regarded as a recusion problem: the transformation equation is that:
minproduction = min(currentnum,maxproduction*currentnum,minproduction*currentnum)
maxproduction = max(currentnum,maxproduction*currentnum,minproduction*currentnum)
The tricky part here is that: for example the premaxproduction is 10, preminproduction is -10
if the current num > 0: 
the maxproduction will be updated -> (maxproduction*current num,current num)
the minproduction will be updated -> (minproduction*current num,current num)
// Here we should compare with the current number because if there is a zero previously, then the current num will larger
// than the maxproduction*current num

else if current num < 0:
a negative number times a negative number will be the positive one while the maxproduction will become negative
swap(maxproduction,minproduction)
update as above
result = max(maxproduct,result)

--------------------------------
Another update formula:
maxproduction = max(maxproduction*currentnum,minproduction*currentnum,currentnum)
minproduction = min(maxproduction*currentnum,minproduction*currentnum,currentnum)

Time Complexity: O(n)
Space Complexity: O(1)
