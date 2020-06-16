package com.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsⅡ {

	public static void main(String[] args) {
		int[] a= {1,2,2}; 
		System.out.println(subsetsWithDup(a).toString());
	}
	
	static List<List<Integer>> list;
	static int n;
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		list = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		n=nums.length;
		Arrays.sort(nums);
		help(nums, 0, tmp);
		return list;
    }

	private static void help(int[] nums, int index, List<Integer> tmp) {
		list.add(new ArrayList<Integer>(tmp));
		for(int i=index;i<n;i++) {
			if(i>index && nums[i]==nums[i-1])
				continue;
			tmp.add(nums[i]);
			help(nums, i+1, tmp);
			tmp.remove(tmp.size()-1);
		}
		
	}
	
}
/*给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
