package com.setANDmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
	
	public static void main(String[] args) {
		int[] a= {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> list=threeSum(a);
		System.out.println(list.toString());
		
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		 List<List<Integer>> ans = new ArrayList<List<Integer>>();
	     int len = nums.length;
	     if(nums == null || len < 3) return ans;
	     Arrays.sort(nums); // 排序
	     for(int i=0;i<len;i++) {//左右指针指向 nums[i]nums[i]后面的两端
	    	 if(nums[i]>0) break;
	    	 if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
	    	 int L=i+1;
	    	 int R=len-1;
	    	while(L<R) {
	    		int sum=nums[i]+nums[L]+nums[R];
	    		if(sum==0) {	
	    			ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
	    			while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
	    		}else if (sum < 0) L++;
                 else if (sum > 0) R--;
	    	}
	     }   
		return ans;
	}
}
/*给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
注意：答案中不可以包含重复的三元组。

示例：

给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]*/
