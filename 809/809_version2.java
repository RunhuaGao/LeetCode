class Solution {
    private String target;
    public int expressiveWords(String S, String[] words) {
        int size = words.length;
        if(size==0 || S.length()==0)
            return 0;
        target = S;
        int result = 0;
        for(String word:words)
            if(compareWord(word)) result++;
        return result;
    }
    private boolean compareWord(String source){
        int sLen = source.length(),tLen = target.length();
        int sstart=0,send=0;
        int tstart=0,tend=0;
        for(send=0,tend=0;sstart<sLen&&tstart<tLen;sstart=send,tstart=tend){
            if(source.charAt(sstart)!=target.charAt(tstart)) return false;
            while(send<sLen&&source.charAt(sstart)==source.charAt(send)) send++;
            while(tend<tLen&&target.charAt(tstart)==target.charAt(tend)) tend++;
            int sDis = send-sstart,tDis = tend-tstart;
            if(sDis!=tDis && tDis < Math.max(3,sDis)) return false;
        }
        return sstart==sLen && tstart==tLen;
    }
}
