class Solution {
    public int kEmptySlots(int[] flowers,int k){
        /* version 2: bucket */
        int n = flowers.length, p=k+1,bs=n/p + 1;
        int[] low_b = new int[bs];
        int[] high_b = new int[bs];
        Arrays.fill(low_b,Integer.MAX_VALUE);
        Arrays.fill(high_b,Integer.MIN_VALUE);
        for(int i=0;i<n;i++){
            int cp = flowers[i];
            int bp = cp/p;
            int day = i+1;
            if(cp < low_b[bp]){
                low_b[bp] = cp;
                if(bp-1>=0 && high_b[bp-1]==cp-p) return day;
            }
            if(cp > high_b[bp]){
                high_b[bp] = cp;
                if(bp+1 < bs && low_b[bp+1]==cp+p) return day;
            }
        }
        return -1;
    }
}