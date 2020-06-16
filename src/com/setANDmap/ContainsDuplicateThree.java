package com.setANDmap;

import java.util.TreeSet;

public class ContainsDuplicateThree {
	public static void main(String[] args) {
		int[] a= {1,2,3,1};
		System.out.println(containsNearbyAlmostDuplicate(a,3,0));
	}
	
	
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		 TreeSet<Long> set = new TreeSet<>();
		 int n=nums.length;
		 for(int i=0;i<n;i++) {
			 Long ceiling = set.ceiling((long) nums[i] - (long) t);
			 if(ceiling !=null && ceiling<=(long)nums[i]+t) {
				 //System.out.println(ceiling+"=="+nums[i]);
				 return true;
			 }
			 set.add((long) nums[i]);
			 if(set.size()==k+1)
				 set.remove((long)nums[i-k]);
		 }
		
		return false;
	}

}
/*给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。

示例 1:

输入: nums = [1,2,3,1], k = 3, t = 0
输出: true
*/

