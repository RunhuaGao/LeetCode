class Solution {
    private String wordOne;
    private String wordTwo;
    private int[][] distance;
    public int minDistance(String word1, String word2) {
        wordOne = word1;
        wordTwo = word2;
        distance = new int[word1.length()+1][word2.length()+1];
        for(int[] d:distance) Arrays.fill(d,-1);
        return editDistance(word1.length(),word2.length());
    }
    
    private int editDistance(int l1,int l2){
        if(l1==0) return l2;
        if(l2==0) return l1;
        if(distance[l1][l2] >=0) return distance[l1][l2];
        int ans;
        if(wordOne.charAt(l1-1)==wordTwo.charAt(l2-1)) ans = editDistance(l1-1,l2-1);
        else ans = 1 + Math.min(Math.min(editDistance(l1-1,l2),editDistance(l1,l2-1)),editDistance(l1-1,l2-1));
        return distance[l1][l2] = ans;
    }
}
