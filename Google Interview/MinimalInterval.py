"""
Problem description:
Given a list intervals with different start and end time: find the minimal subset
of intervals to cover all time duration(the earliest start time, the latest end time)
"""


class Interval:
    def __init__(self, start: int, end: int):
        assert end > start
        self.start = start
        self.end = end


class Solution:
    def findInterval(self, intervals: list) -> list:
        intervals.sort(key=lambda x: x.start)  # sort the interval by start time nlogn time complexity
        res = []
        for i in intervals:
            if not res:
                res.append(i)
            elif i.start == res[-1].start:
                if i.end > res[-1].end:
                    res.pop()
                    res.append(i)
            elif i.end > res[-1].end:
                res.append(i)
        return res


"""
Solution analysis:
This is a typical greedy problem: Please see Leetcode 56: Merge Interval to see details
Sort the interval fist
For each interval, we compare it with previous result interval(like a stack, use stack.peek())
if they have same start time: then only if current's end time is larger than the previous, replace the
previous one with current one // local greedy
if current interval start time is later than the previous, then only if current interval's end time is larger
then append it to the result // local greedy
above two rules follow the local greedy rule
Time Complexity: O(nlogn)
Space Complexity: O(m)(the worst situation is n)
"""
