class Solution:
	def lengthLongestPath(self,input:str) -> int:
            files = input.split("\n")
            path = {0:0}
            max_len = 0
            for f in files:
                level = f.count("\t")
                file_len = len(f) - level
                if "." in f:
                    max_len = max([max_len,path[level]+file_len])
                else:
                    path[level+1] = path[level]+file_len+1
            return max_len
