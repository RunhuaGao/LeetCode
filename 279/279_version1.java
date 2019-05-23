class Solution {
    public int numSquares(int n) {
        if(n<=1) return n;
        List<Integer> result = new ArrayList<>();
        result.add(0);
        result.add(1);
        int number = 2;
        while(number <= n){
            int value = number;
            for(int reduceNum = 1;number-reduceNum*reduceNum>=0;reduceNum++){
                value = Math.min(value,result.get(number-reduceNum*reduceNum)+1);
            }
            result.add(value);
            number+=1;
        }
        return result.get(n);
    }
}
