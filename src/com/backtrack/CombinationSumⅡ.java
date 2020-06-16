package com.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumⅡ {
	public static void main(String[] args) {
		int[] a= {10,1,2,7,6,1,5}; 
		System.out.println(combinationSum2(a,8).toString());
	}
	
	static List<List<Integer>> list;
	static int n;

	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if (candidates.length == 0)
			return list;
		list = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		n = candidates.length;
		Arrays.sort(candidates);
		help(candidates, target, 0, 0, tmp);
		return list;
	}

	private static void help(int[] candidates, int target, int sum, int index, List<Integer> tmp) {
		if (sum == target) {
			list.add(new ArrayList<Integer>(tmp));
			return;
		}
		for (int i = index; i < n; i++) {
			if (sum + candidates[i] > target || (index<i && candidates[i] == candidates[i - 1])) {
				continue;
			}
			tmp.add(candidates[i]);
			sum += candidates[i];

			help(candidates, target, sum, i+1, tmp);
			tmp.remove(tmp.size() - 1);
			sum -= candidates[i];
		}
	}

}
/*
给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
*/
