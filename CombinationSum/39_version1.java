class Solution {
    private int[] nums;
    private Stack<Integer> stack;
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        nums = candidates;
        res = new ArrayList<>();
        stack = new Stack<>();
        dfs(0,target);
        return res;
    }
    
    private void dfs(int start,int currVal){
        if(currVal==0) res.add(new ArrayList<>(stack));
        else{
            for(int i = start;i<nums.length && nums[i] <=currVal;i++){
                stack.push(nums[i]);
                dfs(i,currVal-nums[i]);
                stack.pop();
            }
        }
    }
}
