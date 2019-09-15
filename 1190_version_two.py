# version two: directly reverse the string in place, save a lot of space
class Solution:
    def reverseParentheses(self, s: str) -> str:
        left,right = "(",")"
        self.string = [i for i in s]
        stack = []
        for i in range(len(s)):
            if s[i]==left:
                stack.append(i)
            elif s[i]==right:
                self.reverseString(stack.pop(),i)
        res = "".join(self.string)
        return res.replace(left,"").replace(right,"")
    
    
    def reverseString(self,start,end):
        while start < end:
            self.string[start],self.string[end] = self.string[end],self.string[start]
            start+=1
            end-=1
# reverse the string in place, more elegant and consise method
