# """
# This is Master's API interface.
# You should not implement it, or speculate about its implementation
# """
#class Master:
#    def guess(self, word):
#        """
#        :type word: str
#        :rtype int
#        """

class Solution:
    def findSecretWord(self, wordlist, master):
        """
        :type wordlist: List[Str]
        :type master: Master
        :rtype: None
        """
        time,match = 0,0
        while time < 10 and match < 6:
            candidate = wordlist[random.randint(0,len(wordlist)-1)]
            match = master.guess(candidate)
            wordlist = [i for i in wordlist if self.compareWords(i,candidate)==match]
            time+=1
    
    def compareWords(self,word1,word2):
        res = 0
        for i in range(6):
            if word1[i] == word2[i]:
                res+=1
        return res
