This is such a simple problem about string processing

Solution 1:

My own solution is to count the words, which means that for both the target word(S) and source word
Create a list which contains its current char and the character's frequency
for example, the result of hello is [('h',1),('e',1),('l',2),('o',1)]
then for each word in words(input words list), compare the word's list with the target's list

ie: word = hellllo -> [('h',1),('e',1),('l',3),('o',1)]
the first two elements are equal, skip
for each element, these exist two situations which will result a false comparion: the current characters do not equal
|| target character's frequency != source frequency and target character's frequency < max([3,source frequency])


Time Complexity: O(m+n) m is the length of target word whild n is total length of words list
Space Complexity: O(m+n^2) (to store each source word's information, needs n space)

---------------------------------------------------------------------------------
Solution 2:
Use the four pointers way, more straight forward and easier to understand
for target and source word, each has a start and end pointer
for current position, is target[start]!=source[start]:return fasle
then check the repeat count
while(end < word's length && word[end]==word[start]) end++ (same for target and source word)
check the repeat length: if target's length!=source's length and target's length < source'length or target's length < 3:
return fasle

start = end
return start==length(both for target and source)

Time complexity: O(m+n)
Space complexity: O(1)
