public class NestedIterator implements Iterator<Integer> {
    private int index;
    private List<Integer> array;
    public NestedIterator(List<NestedInteger> nestedList) {
        array = flattenArray(nestedList);
        index = 0;
    }

    @Override
    public Integer next() {
        if(hasNext()){
            int value = array.get(index);
            index+=1;
            return value;
        }
        return -1;
    }

    @Override
    public boolean hasNext() {
        return index < array.size();
        
    }
    
    private List<Integer> flattenArray(List<NestedInteger> nestedList){
        List<Integer> array = new ArrayList<>();
        for(NestedInteger n:nestedList){
            if(n.isInteger()==true) array.add(n.getInteger());
            else{
                for(int i:flattenArray(n.getList())) array.add(i);
            }
        }
        return array;
    }
}
