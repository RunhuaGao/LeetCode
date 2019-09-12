class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int candidate1 = 0,count1=0;
        int candidate2 = 1,count2=0;
        for(int num:nums){
            if (num==candidate1) 
                count1++;
            else if(num==candidate2) count2++;
            else if (count1==0) {
                candidate1 = num;
                count1 = 1;
            } else if(count2==0){
                candidate2 = num;
                count2 = 1;
            }
            else{
                count1--;count2--;
            }
        }
        final List<Integer> res = new ArrayList<>();
        int cnt1 = 0,cnt2 = 0;
        for(int num:nums){
            if(num==candidate1) cnt1++;
            if(num==candidate2) cnt2++;
        }
        int limit = nums.length/3;
        if(cnt1 > limit) res.add(candidate1);
        if(cnt2 > limit) res.add(candidate2);
        return res;
    }
}
// idea: similiar to 169
// algorithm: Boyer-Moore Voting Algorithm
