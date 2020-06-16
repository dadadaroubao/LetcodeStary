package com.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsⅡ {
	
	public static void main(String[] args) {
		int[] s = {1,-1,1,2,-1,2,2,-1};
		System.out.println(permuteUnique(s).size());
	}

	static List<List<Integer>> res;

	public static List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		res = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		boolean[] visited = new boolean[nums.length];
		for (int i = 0; i < nums.length; i++)
			visited[i] = false;
		helper(nums, visited, temp);
		return res;

	}

	public static void helper(int[] nums, boolean[] visited, List<Integer> temp) {
		if (temp.size() == nums.length) {
			res.add(new ArrayList<>(temp));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				temp.add(nums[i]);
				helper(nums, visited, temp);
				temp.remove(temp.size() - 1);
				visited[i] = false;
				while (i + 1 < nums.length && nums[i] == nums[i + 1])//保持不重复
					i++;
			}
		}

	}
	
	
}
/*给定一个可包含重复数字的序列，返回所有不重复的全排列。

示例:

输入: [1,1,2]
输出:
[
  [1,1,2],
  [1,2,1],
  [2,1,1]
]
*/
