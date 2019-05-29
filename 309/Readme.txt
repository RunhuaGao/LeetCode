This is a typical dynammic programming problem
However, it specifies in that it has three status to transform
buy, sell, rest

buy comes from rest, buy
sell comes from buy
rest comes from rest and sell

Use this three transformation equation to establish dynamic equation
Time Complexity: O(n)
Space Complexity: O(1)(current status only depends on previous status)

Huahua's reference
https://zxi.mytechroad.com/blog/dynamic-programming/leetcode-309-best-time-to-buy-and-sell-stock-with-cooldown/
