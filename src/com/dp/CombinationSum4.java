package com.dp;

public class CombinationSum4 {
	
	public static void main(String[] args) {
		int[] a= {1,2,3};
		System.out.println(combinationSum4(a,4));
	}
	
	public static int combinationSum4(int[] nums, int target) {
		if(nums==null || nums.length==0)
			return 0;
		int[] dp = new int[target + 1];
		dp[0]=1;
		for(int i=1;i<=target;i++)
			for (int num : nums) { 
				if(i>=num)
					dp[i]+=dp[i-num];
			}
		return dp[target];
			
	}
	
	

}
/*给定一个由正整数组成且不存在重复数字的数组，找出和为给定目标正整数的组合的个数。

示例:

nums = [1, 2, 3]
target = 4

所有可能的组合为：
(1, 1, 1, 1)
(1, 1, 2)
(1, 2, 1)
(1, 3)
(2, 1, 1)
(2, 2)
(3, 1)

请注意，顺序不同的序列被视作不同的组合。

因此输出为 7。
*/
