public class Combination{
	public void Combination(nums,d,N,s,curr,ans){
		if d == N:
			ans.append(curr);
			return;
		for(i=s;i<nums.length&&condition;i++){
			curr.push(nums[i]);
			Combination(nums,d+1,n,i+1,curr,ans);
		}
	}
}
