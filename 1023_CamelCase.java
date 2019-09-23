class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> res = new ArrayList<>();
        for(final String query:queries) res.add(match(query,pattern));
        return res;
    }
    
    
    private boolean match(final String query,final String pattern){
        int queryIndex =0, patternIndex = 0;
        while(queryIndex < query.length() && patternIndex < pattern.length()){
            char queryChar = query.charAt(queryIndex);
            char patternChar = pattern.charAt(patternIndex);
            if(queryChar==patternChar){
                queryIndex++;
                patternIndex++;
            } else {
                if(!isLowerCase(queryChar)) return false;
                queryIndex++;
             }
        }
        
        while(queryIndex < query.length()){
            if(!isLowerCase(query.charAt(queryIndex))) return false;
            queryIndex++;
        }
        
        return queryIndex==query.length() && patternIndex==pattern.length();
    }
    
    private boolean isLowerCase(char a){
        return a>='a' && a<='z';
    }
     
}

// Index trick match, go through the strings
// Time Complexity: O(summaton(length))
// Space Complexity: O(1)
