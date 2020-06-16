package com.backtrack;



public class N_QueensⅡ {

	public static void main(String[] args) {
		System.out.println(totalNQueens(1));
	}

	
	static boolean[] b1;// 判断列元素是否已经放过皇后
	static boolean[] b2;// 判断正对角线元素是否已经放过皇后
	static boolean[] b3;// 判断反对角线元素是否已经放过皇后
	static int sum ;

	public static int totalNQueens(int n) {
		sum= 0;
		b1 = new boolean[n];
		b2 = new boolean[2 * n - 1];
		b3 = new boolean[2 * n - 1];
		putQueen(n, 0);
		return sum;
	}

	private static void putQueen(int n, int index) {// 摆放到index行的位置
		if (index == n)
			sum++;
		for (int i = 0; i < n; i++) {
			// 尝试index行i列的位置
			if (!b1[i] && !b2[index + i] && !b3[index - i + n - 1]) {
				b1[i] = true;
				b2[index + i] = true;
				b3[index - i + n - 1] = true;
				putQueen(n, index + 1);
				b1[i] = false;
				b2[index + i] = false;
				b3[index - i + n - 1] = false;
			}
		}

	}

	

}
/*
给定一个整数 n，返回 n 皇后不同的解决方案的数量。

示例:

输入: 4
输出: 2
解释: 4 皇后问题存在如下两个不同的解法。
[
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
] 
 */
