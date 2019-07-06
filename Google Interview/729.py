import heapq


class MyCalendar:

    def __init__(self):
        self.heap = []

    def book(self, start: int, end: int) -> bool:
        # empty Calendar
        left, right = 0, len(self.heap) - 1
        mid = -1
        while left <= right:
            mid = (left + right) // 2
            mid_start, mid_end = self.heap[mid]
            if mid_start == start:
                return False
            elif mid_start > start:
                right = mid - 1
            else:
                left = mid + 1
        if left > 0 & start < self.heap[left - 1][0]:
            return False
        elif left < 0 & end > self.heap[left][0]:
            return False
        heapq.heappush(self.heap, [start, end])
        return True
heapq.

"""
Solution Analysis: Maintain a priority queue sorted by 
"""


def test():
    a = MyCalendar()
    a.book(start=15, end=20)
    a.book(start=13, end=20)


test()
