package com.dp;

import java.util.List;

public class Triangle {
	 public int minimumTotal(List<List<Integer>> triangle) {
		int n=triangle.size();
		int[] dp=new int[n]; 
		for(int i=0;i<n;i++)
			dp[i]=triangle.get(n-1).get(i);
		for(int i=n-2;i>=0;i--) {
			for(int j=0;j<triangle.get(i).size();j++) {
				 dp[j] = Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
			}
		}
		return dp[0];	 
	 }
}
/*给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
*/
