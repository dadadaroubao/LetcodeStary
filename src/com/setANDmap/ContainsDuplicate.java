package com.setANDmap;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
	public static void main(String[] args) {
		int[] a= {-1,-1};
		System.out.println(containsNearbyDuplicate(a,1));
	}
	
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer,Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				return true;
			}else {
				map.put(nums[i], 1);
			}
			if(map.size()==k+1) {
				System.out.println("===");
				map.remove(nums[i-k]);
			}
		}
		return false;
    }

}
/*给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。

 

示例 1:

输入: nums = [1,2,3,1], k = 3
输出: true*/

