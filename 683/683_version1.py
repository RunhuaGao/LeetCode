class Solution:
    def kEmptySlots(self, flowers: list, k: int) -> int:
        self.size = len(flowers)
        if self.size == 0 or k >= self.size:
            return -1  # corner case test
        self.bloom = [0] * (self.size + 1)  # maintain an array to record the blooming flower's status
        self.k = k  # store k into an instance variable
        for i in range(self.size):
            day = i + 1  # current day time, as the day starts from 1 in stead of 0
            flower_pos = flowers[i]
            self.bloom[flower_pos] = 1
            if self.check(flower_pos):
                return day
        return -1

    def check(self, center: int) -> bool:
        left_pos, right_pos = center - self.k - 1, center + self.k + 1
        return self.checkHelper(left_pos, center) or self.checkHelper(center, right_pos)

    def checkHelper(self, left: int, right: int) -> bool:
        if left < 0 or right > self.size:
            return False
        elif not self.bloom[left] or not self.bloom[right]:
            return False
        # Test if there is no other flower blooming in range of (left,right)(both inclusive)
        index = left + 1
        while index < right:
            if self.bloom[index]:
                return False
            index += 1
        return True


def test():
    a = [1,3,2]
    s = Solution()
    print(s.kEmptySlots(flowers=a,k=1))


test()