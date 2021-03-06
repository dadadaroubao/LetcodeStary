package com.dp;


public class WiggleSubsequence {
	
	public static void main(String[] args) {
		int[] a= {1,17,5,10,13,15,10,5,16,8}; 
		System.out.println(wiggleMaxLengthMore(a));
	}
	
	public static int wiggleMaxLength(int[] nums) {
		int n=nums.length;
		if(n<2)
			return n;
		int max=0;
		// dp[i][0]表示以下标为i的元素结尾的摆动序列，且序列最后两个元素是递减的最大长度
        // dp[i][1]表示以下标为i的元素结尾的摆动序列，且序列最后两个元素是递增的最大长度
		int[][] dp=new int[n][2];
		dp[0][0]=1;
		dp[0][1]=1;
		for(int i=1;i<n;i++) {
			 // 初始化，最短为1
            dp[i][0] = 1;
            dp[i][1] = 1;
			for(int j=0;j<i;j++) {
				if(nums[i]>nums[j])//递增
					 dp[i][1]=Math.max( dp[i][1], 1+ dp[j][0]);
				else if(nums[i]<nums[j])//递减
					 dp[i][0]=Math.max( dp[i][0], 1+ dp[j][1]);
				// 如果相等，则不需要操作
                // 更新最大值
               max=Math.max(max, dp[i][0]);
               max=Math.max(max, dp[i][1]);
			}
		}
		return max;
	}
	
	 public static int wiggleMaxLengthMore(int[] nums) {
	        if(nums == null || nums.length < 2) {
				return nums == null ? 0 : nums.length;
			}
			int[][] dp = new int[nums.length+1][2];
			
			for(int i=1; i<nums.length; i++) {
				if(nums[i] - nums[i-1] > 0) {
					dp[i+1][1] = Math.max(dp[i][0]+1, dp[i][1]);
				}else if(nums[i] - nums[i-1] < 0) {
					dp[i+1][0] = Math.max(dp[i][1]+1, dp[i][0]);
				}else {
					dp[i+1][1] = dp[i][1];
					dp[i+1][0] = dp[i][0];
				}
			}
			return Math.max(dp[dp.length-1][1], dp[dp.length-1][0])+1;
	    }



}
/*如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。

例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。

给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。

示例 1:

输入: [1,7,4,9,2,5]
输出: 6 
解释: 整个序列均为摆动序列。
示例 2:

输入: [1,17,5,10,13,15,10,5,16,8]
输出: 7
解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
示例 3:

输入: [1,2,3,4,5,6,7,8,9]
输出: 2
*/
