class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        dic = collections.defaultdict(list)
        for word in strs:
            count = [0 for _ in range(26)] # count array as the hashcode
            for char in word:
                count[ord(char)-ord('a')]+=1
            dic[tuple(count)].append(word) # key = tuple count/in java could use string builder
        return dic.values()