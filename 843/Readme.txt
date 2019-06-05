Solution Analysis:
each time we [randomly] select a word from the wordList: candidate <- wordlist.random()
then get the match from master.guess(candidate)
here comes the point, the key is that the answer must exist in that(compareWords(w,candidate)==match)
for example, it match = 0, which means that there is no same character for candidate and secret
then for all words in wordlist, we should also find this kind words(same character = 0)
same for other situations(match = 1,match = 2)
Time Complexity: O(n)(scan the wordlist once each time and will not exceed 10)
Space Complexity: O(n)
