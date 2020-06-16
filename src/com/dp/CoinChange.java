package com.dp;

public class CoinChange {

	public static void main(String[] args) {
		int[] a= {1, 2, 5};
		System.out.println(coinChange(a,11));
		
	}
	
	public static int coinChange(int[] coins, int amount) {
		if (coins == null || coins.length == 0)
			return -1;
		int[] dp = new int[amount + 1];
//dp[i]表示凑够总金额为ii需要的最少的硬币的个数，因为要求得是dp[amount]dp[amount]，即凑够总金额为amountamount时所需要的最少硬币的个数，初始化dpdp时要n+1n+1;
		dp[0] = 0;
		for (int i = 1; i <= amount; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int val : coins) {
				if(i>=val && dp[i-val]!=-1)
					dp[i]=Math.min(dp[i], dp[i-val]+1);
			}
			if (dp[i] == Integer.MAX_VALUE) dp[i] = -1;
		}

		return dp[amount];
	}
}
/*给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。

 

示例 1:

输入: coins = [1, 2, 5], amount = 11
输出: 3 
解释: 11 = 5 + 5 + 1
示例 2:

输入: coins = [2], amount = 3
输出: -1
*/
