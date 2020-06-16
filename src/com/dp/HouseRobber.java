package com.dp;

public class HouseRobber {
	
	public static void main(String[] args) {
		int[] a= {2,7,9,3,1};
		System.out.println(rob(a));
	}
	
	 public int bestrob(int[] nums) {
	        int len = nums.length;
	        if(len == 0)
	            return 0;
	        int[] dp = new int[len + 1];
	        dp[1] = nums[0];
	        for(int i = 2; i <= len; i++) {
	        	//最大值要么是 n-1 房屋可盗窃的最大值，要么就是 n-2 房屋可盗窃的最大值加上当前房屋的值，二者之间取最大值
	            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
	        }
	        return dp[len];
	    }

	
	public static int rob(int[] nums) {
		int n=nums.length;
		if(n==0)
			return 0;
		int[] dp=new int[n];//考虑index到nums.length这个范围的所有房子
		dp[n-1]=nums[n-1];
		for(int i=n-2;i>=0;i--)
			for(int j=i;j<n;j++) {
				dp[i]=Math.max(dp[i], nums[j]+(j+2<n?dp[j+2]:0));
			}
		return dp[0];
	}
	
	public static int rob1(int[] nums) {//超时
		memo=new int[nums.length];
		return tryRob(nums,0);
	}

	static int[] memo;//记忆化搜索
	
	private static int tryRob(int[] nums, int index) {//考虑index到nums.length这个范围的所有房子
		if(index >=nums.length)
			return 0;
		if(memo[index]!=0)
			return memo[index];
		int max=0;
		for(int i=index;i<nums.length;i++)
			max=Math.max(max, nums[i]+tryRob(nums, i+2));
		memo[index]=max;
		return max;
	}

}
/*你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。

示例 1:

输入: [1,2,3,1]
输出: 4
解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 2:

输入: [2,7,9,3,1]
输出: 12
解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
*/
