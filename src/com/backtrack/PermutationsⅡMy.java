package com.backtrack;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsⅡMy {
	
	public static void main(String[] args) {
		int[] s = {1,-1,1,2,-1,2,2,-1};
		System.out.println(permuteUnique(s).size());
	}

	static List<List<Integer>> list ;
	static int[] n;
	static Set<List<Integer>> set=new HashSet<List<Integer>>();
	public static List<List<Integer>> permuteUnique(int[] nums) {
		list=new ArrayList<List<Integer>>();
		n=nums;	
		prem(0);
		return list;
    }

	private static void prem(int m) {
		if(m>=n.length) {
			List<Integer> tmp=new ArrayList<Integer>();
			for (int num : n) {
				tmp.add(num);
			}
			if(!set.contains(tmp)) {
				list.add(new ArrayList<Integer>(tmp));
				set.add(tmp);
			}
		}
		for(int i=m;i<n.length;i++) {
			swap(i,m);
			prem(m+1);
			swap(i,m);
		}
		
	}

	private static void swap(int i, int m) {
		int tmp=n[i];
		n[i]=n[m];
		n[m]=tmp;
		
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
