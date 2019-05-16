class Solution{
	public int lengthLongestPath(String input){
        	HashMap<Integer,Integer> path = new HashMap<>();
        	path.put(0,0);// initialize the hashmap
        	int maxLen = 0;
        	for(String s:input.split("\n")){
            		int level = s.lastIndexOf("\t")+1;
            		int fileLen = s.length()-level;
            		if(s.contains("."))
                		maxLen = Math.max(path.get(level)+fileLen,maxLen);
            		else
                		path.put(level+1,path.get(level)+fileLen+1);
        	}
        	return maxLen;
    	}
}
