package com.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	public static void main(String[] args) {
		System.out.println(combine(4,2).toString());
	}
	
	static List<List<Integer>> list=new ArrayList<List<Integer>>();
	public static List<List<Integer>> combine(int n, int k) {
		if(n<=0 || k<=0 || k>n)
			return list;
		List<Integer> tmp=new ArrayList<Integer>();
		help(n,k,1,tmp);
		return list;
    }
	
	private static void help(int n, int k, int start, List<Integer> tmp) {//start表示从1开始搜索
		if(tmp.size()==k) {
			list.add(new ArrayList<Integer>(tmp));
			return;
		}
		//优化：还有k-tmp.size()个空位，所有【i，n】中至少有k-tmp.size()个元素
		for(int i=start;i<=n-(k-tmp.size())+1;i++) {
			tmp.add(i);
			help(n,k,i+1,tmp);
			tmp.remove(tmp.size()-1);
		}
	}

}
/*给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/
