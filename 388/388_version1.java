class Solution{
	public int lengthLongestPath(String input) {
        	String[] files = input.split("\n");
        	int[] stack = new int[files.length+1];
        	int maxLen = 0;
        	for(String f:files){
            		int level = f.lastIndexOf("\t")+1;
           		stack[level+1] = stack[level]+f.length()-level+1;
            		if(f.contains(".")) maxLen = Math.max(stack[level+1]-1,maxLen);
        }
        return maxLen;
    }
}
