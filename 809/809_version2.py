class Solution:
    def expressiveWords(self, S: str, words: list) -> int:
        self.target = S
        if not self.target or not words:
            return 0
        return sum(self.check(word) for word in words)
    def check(self, source:str):
        s_start,s_end,t_start,t_end = 0,0,0,0
        s_len,t_len = len(source),len(self.target)
        while s_end < s_len and t_end < t_len:
            if self.target[t_start]!=source[s_start]:
                return False
            while s_end < s_len and source[s_end]==source[s_start]:
                s_end+=1
            while t_end < t_len and self.target[t_end]==self.target[t_start]:
                t_end+=1
            s_dis,t_dis = s_end-s_start,t_end-t_start
            if s_dis!=t_dis and t_dis < max([3,s_dis]):return False
            s_start,t_start = s_end,t_end
        return s_start==s_len and t_start==t_len
