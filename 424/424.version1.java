class Solution {
    public int characterReplacement(String s, int k) {
        // The substring with length i minus maxFrequency charactar less or equal to k
        int maxCount = 0,start = 0,res = 0;
        int[] charCount = new int[26];
        for(int end = 0;end<s.length();end++){
            maxCount = Math.max(++charCount[s.charAt(end)-'A'],maxCount);
            while(end-start+1-maxCount>k){
                charCount[s.charAt(start)-'A']--;
                start++;
            }
            res = Math.max(end-start+1,res);
        }
        return res;
    }
