package com.backtrack;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumThree {
	public static void main(String[] args) {
		//int[] a= {10,1,2,7,6,1,5}; 
		System.out.println(combinationSum3(3,9).toString());
	}
	
	static List<List<Integer>> list;
	static int n;

	public static List<List<Integer>> combinationSum3(int k, int n) {
		list = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
		help(k,n,1,0,tmp,0);
		return list;
    }

	private static void help(int k, int n, int index, int sum, List<Integer> tmp,int num) {
		if(sum == n && num==k) {
			list.add(new ArrayList<Integer>(tmp));
			return;
		}
		for(int i=index;i<9;i++) {		
			tmp.add(i);
			sum += i;
			num+=1;
			help(k,n,i+1,sum,tmp,num);
			tmp.remove(tmp.size() - 1);
			sum -=i;
			num-=1;
		}
		
	}

	

}
/*
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：

所有数字都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: k = 3, n = 7
输出: [[1,2,4]]
示例 2:

输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]
*/
