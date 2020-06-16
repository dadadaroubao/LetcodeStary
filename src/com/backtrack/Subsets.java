package com.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		int[] a= {1,2,3}; 
		System.out.println(subsets(a).toString());
	}
	
	static List<List<Integer>> list;
	static int n;
	public static List<List<Integer>> subsets(int[] nums) {
		list = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		n=nums.length;
		help(nums, 0, tmp);
		return list;
    }

	private static void help(int[] nums, int index, List<Integer> tmp) {
		list.add(new ArrayList<Integer>(tmp));
		for(int i=index;i<n;i++) {
			tmp.add(nums[i]);
			help(nums, i+1, tmp);
			tmp.remove(tmp.size()-1);
		}
		
	}
	
}
/*给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/
