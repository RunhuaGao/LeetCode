class Solution {
    private int[] nums;
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        nums = candidates;
        dfs(0,target);
        return res;
    }
    
    private void dfs(int start,int currVal){
        if(currVal==0){
            res.add(new ArrayList<>(path));
        } else if(currVal < 0){
            return;
        } else {
            for(int i = start;i<nums.length && nums[i] <= currVal;i++){
                if(i>start && nums[i]==nums[i-1]) continue;
                path.add(nums[i]);
                dfs(i+1,currVal-nums[i]);
                path.remove(path.size()-1);
            }
        }
    }
}
