package com.dp;

public class IntegerBreak {
	public static void main(String[] args) {
		System.out.println(integerBreak(10));
		
	}
	static int[] dp;
	public static int integerBreak(int n) {
		if(n<=2)
			return 1;
		dp=new int[n+1];
		dp[2]=1;
		dp[1]=1;
		for(int i=3;i<=n;i++) {
			for(int j=1;j<i;j++) {//进行分割，j和i-j
				dp[i]=Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
			}
		}
		return dp[n];
	}
	
	public static int integerBreak2(int n) {
		if(n<=2)
			return 1;
		dp=new int[n+1];
		//dp[2]=1;
		//dp[1]=1;
		 int help = help(n );
		return help;
	}
	
	private static int help(int n) {
		if(n==1)
			return 1;
		if(dp[n]!=0)
			return dp[n];
		int res=1;
		for(int i=1;i<n;i++) 
			res=Math.max(res, Math.max(i*(n-i), i*help(n-i)));
		dp[n]=res;	
		return res;
	}

}
/*给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。

示例 1:

输入: 2
输出: 1
解释: 2 = 1 + 1, 1 × 1 = 1。
示例 2:

输入: 10
输出: 36
解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
*/
