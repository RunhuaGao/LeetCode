class Solution {
    private List<Character> targetChar = new ArrayList<>();
    private List<Integer> targetNumber = new ArrayList<>();
    public int expressiveWords(String S, String[] words) {
        int size = words.length;
        if(size==0 || S.length()==0)
            return 0;
        countWords(targetChar,targetNumber,S); /** initialize target word's information*/
        int result = 0;
        for(String word:words){
            if(compareWords(word)) result++;
        }
        return result;
    }
    
    private void countWords(List<Character> charList, List<Integer> numberList,String word){
        if(word.length()==0)
            return;
        else{
            int index = 0;
            while(index < word.length()){
                int end = index+1; /**Two pointers */
                while(end < word.length()&&word.charAt(end)==word.charAt(end-1))
                    end+=1;
                charList.add(word.charAt(index));
                numberList.add(end-index);
                index = end;
            }
        }
    }
    
    private boolean compareWords(String word){
        List<Character> wordChar = new ArrayList<>();
        List<Integer> wordNumber = new ArrayList<>();
        countWords(wordChar,wordNumber,word);
        if(wordChar.size()!=targetChar.size())
            return false;
        int index = 0;
        while(index < wordChar.size()){
            Character tChar = targetChar.get(index);
            Character sChar = wordChar.get(index);
            if(tChar!=sChar) return false;
            Integer tNumber = targetNumber.get(index);
            Integer sNumber = wordNumber.get(index);
            if(tNumber==2 && sNumber==1) return false;
            if(tNumber < sNumber) return false;
            index++;
        }
        return true;
    }
}
