# General Dynamic programming & two dimensional array
class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        level = len(triangle)
        curr_level = 1
        dp = [[triangle[0][0]]]
        while curr_level < level:
            temp = [0 for _ in range(curr_level+1)]
            pre_level = dp[curr_level-1]
            for i in range(curr_level+1):
                curr_cost = triangle[curr_level][i]
                pre_left,pre_right = i-1,i
                pre_left_cost = dp[curr_level-1][pre_left] if pre_left >=0 else float("inf")
                pre_right_cost = dp[curr_level-1][pre_right] if pre_right < curr_level else float("inf")
                temp[i] = min([pre_left_cost,pre_right_cost])+curr_cost
            dp.append(temp)
            curr_level+=1
        return min(dp[-1])
