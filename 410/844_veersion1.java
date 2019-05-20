class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> one = processString(S);
        Stack<Character> two = processString(T);
        if(one.size()!=two.size()) return false;
        while(!one.empty()){
            Character o = one.pop();
            Character t = two.pop();
            if(o!=t) return false;
        }
        return true;
    }
    
    private Stack<Character> processString(String s){
        Stack<Character> stack = new Stack<>();
        char split = '#';
        for(char c:s.toCharArray()){
            if(c!=split) stack.push(c);
            else if(!stack.empty()) stack.pop();
        }
        return stack;
    }
}
