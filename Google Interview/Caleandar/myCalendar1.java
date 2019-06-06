class MyCalendar {
    TreeMap<Integer,Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer leftKey = map.floorKey(start);
        if(leftKey!=null && map.get(leftKey) > start) return false;
        Integer rightKey = map.ceilingKey(start);
        if(rightKey!=null && rightKey < end) return false;
        map.put(start,end);
        return true;
    }
}

