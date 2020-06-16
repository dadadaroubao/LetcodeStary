package com.dp;

public class BestTimeToBuyAndSellStockWithCooldown {
	
	public static void main(String[] args) {
		int[] a= {1,2,3,0,2};
		System.out.println(maxProfit(a));
	}
	
	public static int maxProfit(int[] prices) {
		int n=prices.length;
		if(n<2)
			return 0;
		//dp[i][j] 表示 [0, i] 区间内，到第 i 天（从 0 开始）状态为 j 时的最大收益。
		int[][] dp=new int[n][3];
		
		dp[0][0]=0;//代表不持股的状态
		dp[0][1]=-prices[0];//代表持股的状态
		dp[0][2]=0;////代表冻结期的状态
		
		for(int i=1;i<n;i++) {
			//不持股的状态为前一天不持股，今天不改变或者前一天持股，今天卖掉
			dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
			//持股的状态为前一天持股，今天不改变或者前一天冻结，今天买股
			dp[i][1]=Math.max(dp[i-1][2]-prices[i], dp[i-1][1]);
			//冻结的状态为前一天买掉股
			dp[i][2]=dp[i-1][0];
		}
		return Math.max(dp[n-1][0], dp[n-1][2]);
	}

}
/*给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​

设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:

你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
示例:

输入: [1,2,3,0,2]
输出: 3 
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
*/
