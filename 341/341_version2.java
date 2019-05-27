public class NestedIterator implements Iterator<Integer> {
    private Stack<NestedInteger> stack = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size()-1;i>=0;i--) stack.push(nestedList.get(i)); // push all elements into stack
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!stack.empty()){
            NestedInteger top = stack.peek();
            if(top.isInteger()) return true;
            stack.pop();// pop out the top element: which is a List<NestedInteger>
            for(int i = top.getList().size()-1;i>=0;i--) stack.push(top.getList().get(i));
        }
        return false;
        
    }
    
}
