class Solution {
    public int minDistance(String word1, String word2) {
        if(word1.equals(word2)) return 0; // corner case
        int[][] d = new int[word1.length()+1][word2.length()+1];
        for(int i = 0;i<=word1.length();i++){
            for(int v = 0;v<=word2.length();v++){
                if(i == 0) d[i][v] = v;
                else if(v == 0) d[i][v] = i;
                else if(word1.charAt(i-1)==word2.charAt(v-1)) d[i][v] = d[i-1][v-1];
                else d[i][v] = 1 + Math.min(Math.min(d[i-1][v],d[i][v-1]),d[i-1][v-1]);
            }
        }
        return d[word1.length()][word2.length()];
    }
}
