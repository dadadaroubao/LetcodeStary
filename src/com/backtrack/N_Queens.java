package com.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N_Queens {

	public static void main(String[] args) {
		int a=6;
		System.out.println(solveNQueens(a).toString());
		System.out.println(solveNQueens(a).size());
	}

	static List<List<String>> list;
	static boolean[] b1;// 判断列元素是否已经放过皇后
	static boolean[] b2;// 判断正对角线元素是否已经放过皇后,行列差相等
	static boolean[] b3;// 判断反对角线元素是否已经放过皇后,行列和相等

	public static List<List<String>> solveNQueens(int n) {
		list = new ArrayList<List<String>>();
		List<Integer> tmp = new ArrayList<Integer>();
		b1 = new boolean[n];
		b2 = new boolean[2 * n - 1];
		b3 = new boolean[2 * n - 1];
		putQueen(n, 0, tmp);
		return list;
	}

	private static void putQueen(int n, int index, List<Integer> tmp) {// 摆放到index行的位置
		if (index == n)
			list.add(generateBoard(n, tmp));
		for (int i = 0; i < n; i++) {
			//尝试index行i列的位置
			if (!b1[i] && !b2[index + i] && !b3[index - i + n - 1]) {
				tmp.add(i);
				b1[i] = true;
				b2[index + i] = true;
				b3[index - i + n - 1] = true;
				putQueen(n, index + 1, tmp);
				tmp.remove(tmp.size() - 1);
				b1[i] = false;
				b2[index + i] = false;
				b3[index - i + n - 1] = false;
			}
		}

	}

	private static List<String> generateBoard(int n, List<Integer> tmp) {
		  List<String> res = new ArrayList<>();
          for(Integer num:tmp){
              char[] t = new char[n];
              Arrays.fill(t,'.');
              t[num] = 'Q';
              res.add(new String(t));
          }        
          return res;
	}

}
/*
 * n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 上图为 8 皇后问题的一种解法。 给定一个整数
 * n，返回所有不同的 n 皇后问题的解决方案。
 * 
 * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * 
 * 示例:
 * 
 * 输入: 4 输出: [ [".Q..", // 解法 1 "...Q", "Q...", "..Q."],
 * 
 * ["..Q.", // 解法 2 "Q...", "...Q", ".Q.."] ] 解释: 4 皇后问题存在两个不同的解法。   提示：
 * 
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一或七步
 * ，可进可退。
 */
