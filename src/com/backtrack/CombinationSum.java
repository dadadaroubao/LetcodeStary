package com.backtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
	public static void main(String[] args) {
		int[] a= {8,3,4,7}; 
		System.out.println(combinationSum(a,11).toString());
	}
	
	static List<List<Integer>> list;
	static int n;

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates.length == 0)
			return list;
		list = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		n = candidates.length;
		help(candidates, target, 0, 0, tmp);
		return list;
	}

	private static void help(int[] candidates, int target, int sum, int index, List<Integer> tmp) {
		if (sum == target) {
			list.add(new ArrayList<Integer>(tmp));
			return;
		}
		for (int i = index; i < n; i++) {
			if (sum + candidates[i] > target) {
				continue;
			}
			tmp.add(candidates[i]);
			sum += candidates[i];

			help(candidates, target, sum, i, tmp);
			tmp.remove(tmp.size() - 1);
			sum -= candidates[i];
		}
	}

}
/*给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [2,3,6,7], target = 7,
所求解集为:
[
  [7],
  [2,2,3]
]
示例 2:

输入: candidates = [2,3,5], target = 8,
所求解集为:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
*/
