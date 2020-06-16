package com.setANDmap;

import java.util.Arrays;

public class Sum3Closest {
	public static void main(String[] args) {
		int[] nums= {-1,2,1,-4};
		System.out.println(threeSumClosest(nums,1));
	}
	
	public static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        int len=nums.length;
        for(int i=0;i<len-2;i++) {
        	int l=i+1;
        	int r=len-1;
        	while(l<r) {
        		int sum=nums[i]+nums[l]+nums[r];
        		if(Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
        		if(sum > target)
                    r--;
                else if(sum < target)
                    l++;
                else
                	return ans;
        	}
        }
		return ans;
    }

}
/*给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).*/
