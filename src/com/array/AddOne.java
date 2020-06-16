package com.array;

import java.util.Arrays;

public class AddOne {
	public static void main(String[] args) {
		int[] a= {9,8,7,6,5,4,3,2,1,0}; 
		System.out.println(Arrays.toString(plusOne(a)));
	}

	
	public static int[] plusOne(int[] digits) {
		Long sum=0l;
		for (int i : digits) {
			sum=i+sum*10;
		}
		String s=(sum+1)+"";
		int n=s.length();
		int[] a=new int[n];
		for (int i = 0; i < n; i++) {
			a[i]=Integer.parseInt(s.substring(i, i+1));
		}
	
		return a;
	}
}
/*给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1:

输入: [1,2,3]
输出: [1,2,4]
解释: 输入数组表示数字 123。*/
