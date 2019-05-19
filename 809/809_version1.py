class Solution:
    def expressiveWords(self, S: str, words: list) -> int:
        size = len(words)
        if size == 0:
            return size
        elif not S:
            return 0
        else:
            numder = 0
            self.target_list = self.countWord(S)
            for w in words:
                if self.compareWords(w):
                    numder += 1
            return numder

    def countWord(self, word):
        result = []
        start = 0
        while start < len(word):
            end = start + 1
            while end < len(word) and word[end] == word[end - 1]:
                end += 1
            # if end == len(word):
            #     break
            distance = end - start
            result.append((word[start], distance))
            start = end
        return result

    def compareWords(self, source):
        source_list = self.countWord()
        if len(source_list) != len(self.target_list):
            return False
        else:
            index = 0
            while index < len(source_list):
                s_char, s_len, t_char, t_len = source_list[index], self.target_list[index]
                if s_char != t_char:
                    return False
                elif s_len > t_len:
                    return False
                elif s_len == 1 and t_len == 2:
                    return False
                index += 1
            return True


def test():
    a = Solution()
    b = a.countWord("hello")
    print(b)


test()
