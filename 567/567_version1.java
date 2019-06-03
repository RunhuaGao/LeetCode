// sliding window to check string: always used in string
class Solution {
    private int[] target = new int[26];
    private int[] curr = new int[26];
    public boolean checkInclusion(String s1, String s2) {
        int size1 = s1.length(),size2 = s2.length();
        if(size2 < size1) return false; // corner case 1: less length
        fillArray(s1,target);fillArray(s2.substring(0,size1),curr); // initialize status
        for(int position = size1;position<size2;position++){ // sliding window: constant time to change string
           if(checkStatus()) return true;
            // update current status
            char currChar = s2.charAt(position);
            curr[currChar-97]+=1;
            char deleChar = s2.charAt(position-size1);
            curr[deleChar-97]-=1;
        }
        return checkStatus();
    }
    
    // check if target & current int array equal
    private boolean checkStatus(){
        for(int i=0;i<26;i++){
            if(target[i]!=curr[i]) return false;
        }
        return true;
    }
    
    // fill the array with a substring: frequency dictionary    
    private void fillArray(String s, int[] status){
        for(char a:s.toCharArray()) status[a-97]+=1;
    }
}
