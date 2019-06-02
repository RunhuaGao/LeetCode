class Solution {
    public int integerBreak(int n) {
        int[] cache = new int[n+1];
        cache[1] = 1;cache[2] = 1;
        int curr = 3;
        while(curr <= n){
            int res = 0;
            for(int temp = 1;temp <= curr/2+1;temp++){
                int option1 = temp * (curr-temp);
                int option2 = temp * cache[curr-temp];
                res = Math.max(res,Math.max(option1,option2));
            }
            cache[curr] = res;
            curr++;
        }
        return cache[n];
    }
}
