public class Solution{
    private int[] bloom;
    private int size;
    private int k;
    /**
     * @param flowers the order of blooming for all flowers
     * @param k the k distacne required
     * @return if there exists a two flowers with k distance
     */
    public boolean kEmptySlots(int[] flowers, int k){
        size = flowers.length;
        k = k;
        if (size == 0 || k >= size) return -1; // corner case test
        bloom = new int[size+1];
        for(int i=0;i<size;i++){
            int day = i+1;
            bloom[i] = 1;
            if (check(flowers[i])) return day;
        }
        return -1;
    }

    private boolean check(int center){
        int leftPos = center-k-1,rightPos = center+k+1;
        return checkHelper(leftPos,center) || checkHelper(center,rightPos);
    }

    private boolean checkHelper(int left,int right){
        if(left <= 0 || right >size) return false;
        else if(bloom[left]==0 || bloom[right]==0) return false;
        int index = left+1;
        while(index < right){
            if (bloom[index]) return false;
            index++;
        }
        return true;
    }
}