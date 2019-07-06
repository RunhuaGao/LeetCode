class Solution:
    def isNStraightHand(self, hand: list, W: int) -> bool:
        if len(hand) % W > 0: return False
        count = {}
        for i in hand:
            count[i] = count.get(i, 0) + 1
        minNumber, maxNumber = min(hand), max(hand)
        start = minNumber
        while start < maxNumber:
            curr_num = count.get(start, 0)
            if curr_num > 0:
                end = start
                while end <= start + W - 1:
                    if count.get(end, 0) - curr_num < 0:
                        return False
                    else:
                        count[end] -= curr_num
                    end += 1
            start += 1
        return sum(count.values()) == 0


Solution().isNStraightHand(hand=[1, 2, 3, 6, 2, 3, 4, 7, 8], W=3)
