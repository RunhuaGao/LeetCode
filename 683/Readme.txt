Solution Analysis:

The first method is just the brute force method
Each time we add a flower's position to the array, just check its tow sides' status
If it satisfies the condition(center-k-1==1 and no other flowers in this range, same for right point and center+k+1==1)
then directly return the current day(note that the day starts from 1 instead of 0)
Time Complexity: O(nk)
Space Complexity: O(n)

The second method is an advanced method
As actually we do noe need to record each posistion, instead, we need to "compress the status"
So in this case, we maintain two arrays, one to record the lowest position for each bucket, the other is for highest
bucket size equals (n//(k+1) + 1): just a direct calculation, not so much mathematical process
then for each day and position, we compare it with both high and low record array
first, calculate it's bucket position(position/k+1)
then if it is lower than the position at low[bucket_position], update and check if the high[bucket_position-1] == positon-k-1
if it is higher than the posiiton at high[bucket_position], update and check if the low[bucket_positon+1]==position+k+1
if one of the above condiiton meets, return day(i+1)
else: return -1
Time Complexity: O(n)
Space Complexity: O(n)
