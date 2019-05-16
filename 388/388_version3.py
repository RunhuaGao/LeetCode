class Solution:
    def lengthLongestPath(self, input: str) -> int:
        files = input.split("\n")
        stack = []
        max_len,curr_len = 0,0 #initialize the length
        for f in files:
            level = f.count("\t")
            file_len = len(f)-level+1
            while len(stack) > level:
                curr_len-=stack.pop()
            curr_len+=file_len
            if "." in f:
                max_len = max([max_len,curr_len-1])
            stack.append(file_len)
        return max_len
