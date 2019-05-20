class Solution:
    def backspaceCompare(self, S: str, T: str) -> bool:
        return self.processString(S) == self.processString(T)
    
    
    def processString(self,s):
        stack = []
        back = "#"
        point = 0
        while point < len(s):
            if s[point]!=back:
                stack.append(s[point])
            else:
                if stack: stack.pop()
            point+=1
        return "".join(stack)
