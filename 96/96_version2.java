class Solution {
    int[] cache;
    public int numTrees(int n) {
        cache = new int[n+1];
        cache[0] = 1;cache[1] = 1;
        return numTreesHelper(n);
    }
    
    private int numTreesHelper(int k){
        if(cache[k] > 0) return cache[k];
        int res = 0;
        for(int i = 1;i<=k;i++){
            res+=numTreesHelper(i-1)*numTreesHelper(k-i);
        }
        cache[k] = res;
        return cache[k];
    }
}
