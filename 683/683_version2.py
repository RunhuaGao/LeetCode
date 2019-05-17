class Solution:
    def kEmptySlots(self, flowers: list, k: int) -> int:
        # version 2: Bucket
        n = len(flowers)
        p = k + 1
        bs = n // p + 1
        max_b, min_b = [-float("inf")] * bs, [float("inf")] * bs
        for i in range(n):
            bp = flowers[i]//p
            cp = flowers[i]
            day = i+1
            if cp > max_b[bp]:
                max_b[bp] = cp
                if bp+1 < bs and min_b[bp+1] == cp+p:return day
            if cp < min_b[bp]:
                min_b[bp] = cp
                if bp-1>=0 and max_b[bp-1] == cp-p: return day
        return -1