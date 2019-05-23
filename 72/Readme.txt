Soluton Analysis:

This is a classical dynnamic programming
(from here we know that for the string processing question, we could use two pointers or dp as a general solution)

The intuition is that: as we have three operations available, for example, the word1 is abbc and word2 is abc

In this case, as their last characters are same, so the editDistance("abbc","abc") is as same as the editDistance("abb","ab")
because wo do not need to execute any operation on the their last characters
and for "abb" and "ab", same as above, its editDistance = editDistance("ab","a")
Here comes another situation that the two words' last characters do not equal
and we have three options:
editDistance("ab","") (delete a in "a")
editDistance("a","a") (delete b in "ab")
editDistance("a",") (replace "b" in "ab" with a)
return the minimum distance between these three values plus 1(current delete/replacement operation)

Time Complexity: O(m*n)
Space Complexity: O(m*n)
