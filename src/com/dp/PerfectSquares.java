package com.dp;

import java.util.Arrays;


public class PerfectSquares {
	public static void main(String[] args) {
		System.out.println(numSquares(12));
	}
	
	public static int numSquares(int n) {
        int[] dp=new int[n+1]; 
        Arrays.fill(dp,1,n+1,Integer.MAX_VALUE);
        for(int i=1;i<=n;i++){
            for (int j=1;j*j<=i;j++){ 
                dp[i]=Math.min(dp[i],dp[i-j*j]+1);  //dp[i]可能会有多种选择,j是变化的
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[n];
    }


}
/*给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。

示例 1:

输入: n = 12
输出: 3 
解释: 12 = 4 + 4 + 4.
示例 2:

输入: n = 13
输出: 2
解释: 13 = 4 + 9. */
