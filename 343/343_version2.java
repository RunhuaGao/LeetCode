class Solution {
    private int[] cache;
    public int integerBreak(int n) {
        cache = new int[n+1];
        cache[1] = 1;cache[2] = 1;
        return recur(n);
    }
    
    private int recur(int n){
        if(n<=2) return cache[n];
        if(cache[n] > 0) return cache[n];
        int res = 0;
        for(int temp = 1;temp<=n/2+1;temp++){
            int option1 = temp * (n-temp);
            int option2 = temp * recur(n-temp);
            res = Math.max(res,Math.max(option1,option2));
        }
        cache[n] = res;
        return cache[n];
    }
}
