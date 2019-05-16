class Solution:
	def lengthLongestPath(self, input: str) -> int:
        files = input.split("\n")
        stack = [0]*(len(files)+1)
        level_sp = "\t"
        file_ex = "."
        max_len = 0
        print(files)
        for f in files:
            level = f.count("\t")
            stack[level+1] = stack[level]+len(f)-level+1
            if file_ex in f:
                max_len = max([stack[level+1]-1,max_len])
        return max_len
