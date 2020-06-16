package com.dp;

import java.util.Arrays;

public class MinimumPathSum {
	
	public static void main(String[] args) {
		int[][] a= {{1,3,1},{1,5,1},{4,2,1}}; 
		System.out.println(minPathSum(a));
	}
	
	 public static int minPathSum(int[][] grid) {
		int n=grid.length;
		int m=grid[0].length;
		int[][] dp=grid;
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++) {
				if(i==0 && j==0)
					continue;
				else if(i==0)//只能从左边来
					dp[i][j]=dp[i][j]+dp[i][j-1];
				else if(j==0)
					dp[i][j]=dp[i][j]+dp[i-1][j];
				else
					dp[i][j]=Math.min(dp[i][j-1], dp[i-1][j])+dp[i][j];
			}
		for (int[] is : dp) {
			System.out.println(Arrays.toString(is));
		}
		
		return dp[n-1][m-1]; 
	 }
	 

}
/*给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。

示例:

输入:
[
  [1,3,1],
  [1,5,1],
  [4,2,1]
]
输出: 7
解释: 因为路径 1→3→1→1→1 的总和最小。
*/
