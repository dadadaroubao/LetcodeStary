package com.setANDmap;

import java.util.HashMap;
import java.util.Map;

public class HappyNumber {
	public static void main(String[] args) {
		int n=19;
		System.out.println(isHappy(n));
	}

	
	 public static  boolean isHappy(int n) {
		 	boolean flog=true;
		 	Map<Integer, Integer> map=new HashMap<Integer,Integer>();
		 	map.put(n, 1);
		 	while(n!=1) {
		 		
		 		int len=(n+"").length();
		 		int sum=0;
		 		for(int i=len;i>0;i--) {
		 			sum+=(int)Math.pow(n % (int)Math.pow(10,i) / (int)Math.pow(10, i - 1) , 2);
		 		}
		 		if(map.get(sum)!=null) {
		 			return false;
		 		}
		 		map.put(sum, 1);
		 		n=sum;
		 	}
		 	return flog;
	    }
}
/* 202
 * 编写一个算法来判断一个数是不是“快乐数”。

一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。
如果可以变为 1，那么这个数就是快乐数。

示例: 

输入: 19
输出: true
解释: 
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
 */
