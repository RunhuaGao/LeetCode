"""
Problem description:
We have a two dimension map, at which position it may be land or ocean
"W" stands for land, "O" stands for ocean
The height of ocean is 0 and the height difference between two neighbor points will not exceed one
"""

import queue


class Solution:
    def MaxHeight(self, map: list):
        self.map = map
        self.col = len(map[0])
        self.row = len(map)
        default = float("inf")
        self.state = [[default for _ in range(self.col)] for _ in range(self.row)]
        for r in range(self.row):
            for c in range(self.col):
                if map[r][c] == "O":  # current position is water, we know it's height is zero, extend
                    self.state[r][c] = 0
                    self.bfs(r, c)
        res = 0
        for r in range(self.row):
            for c in range(self.col):
                res = max([res, self.state[r][c]])
        print(self.state)
        return res

    def bfs(self, cr, cc):
        q = queue.Queue()
        q.put([cr, cc, 0])
        visited = set()
        while not q.empty():
            center_r, center_c, height = q.get()
            neighbor_pos = [[center_r, center_c - 1], [center_r, center_c + 1], [center_r - 1, center_c],
                            [center_r + 1, center_c]]
            for r, c in neighbor_pos:
                if self.isLegalPos(r, c) and self.map[r][c] == "W" and (r, c) not in visited:
                    self.state[r][c] = min([self.state[r][c], height + 1])
                    q.put([r, c, self.state[r][c]])
                    visited.add((r, c))

    def isLegalPos(self, r, c):
        return r >= 0 and r < self.row and c >= 0 and c < self.col


def test():
    a = Solution()
    map = [["O", "W", "W", "W", "W"],
           ["W", "W", "W", "W", "W"],
           ["W", "W", "W", "W", "W"]]
    print(a.MaxHeight(map))


test()
