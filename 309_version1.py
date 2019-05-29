class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if not prices:
            return 0
        days = len(prices)
        rest,buy,sell = 0,-float("inf"),0
        for p in prices:
            pre_sold = sell
            sell = buy+p
            buy = max([buy,rest-p])
            rest = max([rest,pre_sold])
        return max([rest,sell])
