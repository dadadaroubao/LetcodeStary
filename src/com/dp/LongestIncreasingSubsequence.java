package com.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	
	public static void main(String[] args) {
		int[] a= {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLIS(a));
	}
	
	public static int lengthOfLIS(int[] nums) {
		int n=nums.length;
		if(n<2)
			return n;
		int max=0;
		//第i个数字结尾的 最长的上升子序列的长度
		int[] LIS=new int[n];
		Arrays.fill(LIS, 1);
		for(int i=1;i<n;i++) {
			for(int j=0;j<i;j++) 
				if(nums[i]>nums[j])
					LIS[i]=Math.max(LIS[i], 1+LIS[j]);
			max=Math.max(LIS[i], max);
		}
		return max;
	}

}
/*给定一个无序的整数数组，找到其中最长上升子序列的长度。

示例:

输入: [10,9,2,5,3,7,101,18]
输出: 4 
解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
*/
