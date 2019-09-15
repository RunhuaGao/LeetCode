// version 1: mupltiple stacks, maintain the parentDegree and reverse
class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> stack1 = new Stack<>();
        List<Stack> stacks = new ArrayList<>();
        stacks.add(new Stack<Character>());
        char leftParent = '(',rightParent = ')';
        int index = 0;int inParentDegree = 0;
        while(index < s.length()) {
            char currChar = s.charAt(index);
            if(currChar==leftParent){
                inParentDegree++;
                if(inParentDegree==stacks.size()) stacks.add(new Stack<Character>());
            } else if(currChar==rightParent){
                while(stacks.get(inParentDegree).size() > 0){
                    stacks.get(inParentDegree-1).push(stacks.get(inParentDegree).pop());
                }
                inParentDegree--;
            } else {
                stacks.get(inParentDegree).push(currChar);
            }
            index++;
        }
        Stack<Character> resStack = stacks.get(0);
        char[] res = new char[resStack.size()];
        index = 0;
        for(char ch:resStack){
            res[index] = ch;
            index++;
        }
        return String.valueOf(res);
        
    }
}
