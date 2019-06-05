/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        Random seed = new Random();
        for(int time = 0,match = 0;time < 10 && match < 6;time++){
            String candidate = wordlist[seed.nextInt(wordlist.length)];
            List<String> newWordList = new ArrayList<>();
            match = master.guess(candidate);
            for(String w:wordlist) 
                if(compareWords(w,candidate)==match)
                    newWordList.add(w);
            wordlist = newWordList.toArray(new String[newWordList.size()]);
        }
    }
    
    
    private int compareWords(String a,String b){
        int res = 0;
        for(int i = 0;i<6;i++){
            if(a.charAt(i) == b.charAt(i)) res++;
        }
        return res;
    }
}
