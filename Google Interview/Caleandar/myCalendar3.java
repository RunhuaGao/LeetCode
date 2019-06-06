class MyCalendarThree {
    TreeMap<Integer,Integer> map;
    public MyCalendarThree() {
        map = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        map.put(start,map.getOrDefault(start,0)+1); // new event starts at time start
        map.put(end,map.getOrDefault(end,0)-1); // new event ends at time end
        int k = 0,onGoing = 0;
        for(int v:map.values()) k = Math.max(k,onGoing+=v);
        return k;
    }
}
