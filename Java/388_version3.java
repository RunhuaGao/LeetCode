class Solution {
    public int lengthLongestPath(String input) {
        String[] files = input.split("\n");
        int maxLen = 0,currLen = 0;
        Stack<Integer> stack = new Stack<>();
        for(String f:files){
            int level = f.lastIndexOf("\t")+1;
            int fileLen = f.length()-level+1;
            while(stack.size() > level)
                currLen-=stack.pop();
            currLen+=fileLen;
            if(f.contains("."))
                maxLen = maxLen>currLen-1?maxLen:currLen-1;
            stack.push(fileLen);
        }
        return maxLen;
    }
}
