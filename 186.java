class Solution {
    public void reverseWords(char[] s) {
        int left = 0,right = s.length-1;
        // step1: reverse whole string
        reverse(left,right,s);
        // step2: reverse each word in s
        int start = 0;
        char empty = ' ';
        while(start < s.length){
            int end = start;
            while(end < s.length && s[end]!=empty) end++;
            reverse(start,end-1,s);
            if(end==start) start++;
            else start = end+1;
        }
    }
    
    
    private void reverse(int left,int right,char[] chars){
        while(left < right){
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right] = temp;
            right--;
        }
    }
}
// time complexity: O(n)
// space complexity: O(1)
