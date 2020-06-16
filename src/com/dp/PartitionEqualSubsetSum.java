package com.dp;

public class PartitionEqualSubsetSum {

	public static void main(String[] args) {
		int[] nums= {1, 5, 11, 5};
		System.out.println(canPartition(nums));
	}
	//dp
	public static boolean canPartition(int[] nums) {
		int sum=0;
		for (int i : nums) 
			sum+=i;
		if(sum%2 != 0)
			return false;
		int n=nums.length;
		int c=sum/2;
		boolean[] b=new boolean[c+1];
		for(int i=0;i<=c;i++)
			b[i]=(nums[0]==i);
		for(int i=1;i<n;i++)
			for(int j=c;j>=nums[i];j--)
				b[j]=b[j] || b[j-nums[i]];
		return b[c];
	}
	
	private static int[][] memo;//0到i的元素是否可以填充容量为c的背包
	//0代表为处理，1代表不可以填充，2代表可以填充
	
	//在n个物品填满sum/2的背包
	public static boolean canPartition2(int[] nums) {
		int sum=0;
		for (int i : nums) 
			sum+=i;
		if(sum%2 != 0)
			return false;
		memo=new int[nums.length][sum/2+1];
		return tryPartition(nums,nums.length-1,sum/2);
	}

	private static boolean tryPartition(int[] nums, int index, int sum) {
		if(sum == 0)
			return true;
		if(sum<0 || index<0)
			return false;
		if(memo[index][sum] != 0)
			return memo[index][sum]==2;
		memo[index][sum]=(tryPartition(nums,index-1,sum) || tryPartition(nums,index-1,sum-nums[index]))?2:1;
		return memo[index][sum]==2;
	}
}
/*给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意:

每个数组中的元素不会超过 100
数组的大小不会超过 200
示例 1:

输入: [1, 5, 11, 5]

输出: true

解释: 数组可以分割成 [1, 5, 5] 和 [11].
 

示例 2:

输入: [1, 2, 3, 5]

输出: false
*/
