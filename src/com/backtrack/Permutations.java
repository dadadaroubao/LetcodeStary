package com.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	public static void main(String[] args) {
		int[] s = {1,2,3};
		System.out.println(permute(s));
	}

	static List<List<Integer>> list ;
	static int[] n;
	
	public static List<List<Integer>> permute(int[] nums) {
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
			list.add(new ArrayList<Integer>(tmp));
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
/*给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
*/
