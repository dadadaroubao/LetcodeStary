package com.backtrack;

public class SudokuSolver {
	// 三个布尔数组 表明 行, 列, 还有 3*3 的方格的数字是否被使用过
	boolean[][] rowUsed;
	boolean[][] colUsed;
	boolean[][][] boxUsed;
	int n;
	int m;

	public void solveSudoku(char[][] board) {
		rowUsed = new boolean[9][10];
		colUsed = new boolean[9][10];
		boxUsed = new boolean[3][3][10];
		n = board.length;
		m = board[0].length;
		// 进行初始化
		for (int row = 0; row < board.length; row++)
			for (int col = 0; col < board[0].length; col++) {
				int num = board[row][col] - '0';
				if (1 <= num && num <= 9) {
					rowUsed[row][num] = true;// 第row行的num以使用过
					colUsed[col][num] = true;
					boxUsed[row / 3][col / 3][num] = true;
				}
			}
		// 递归的填充数组
		padding(board, 0, 0);
	}
	
		
	private boolean padding(char[][] board, int row, int col) {
		// 边界校验, 如果已经填充完成, 返回true, 表示一切结束
		if (col == m) {
			col = 0;
			row++;
			if (row == n)
				return true;
		}
		// 是空则尝试填充, 否则跳过继续尝试填充下一个位置
		if (board[row][col] == '.') {
			// 尝试填充1~9
			for (int num = 1; num < 10; num++) {
				if (!rowUsed[row][num] && !colUsed[col][num] && !boxUsed[row / 3][col / 3][num]) {// 同时满足三个数组
					rowUsed[row][num] = true;
					colUsed[col][num] = true;
					boxUsed[row / 3][col / 3][num] = true;
					board[row][col] = (char) ('0' + num);
					if (padding(board, row, col + 1)) {
						return true;
					}
					board[row][col] = '.';
					rowUsed[row][num] = false;
					colUsed[col][num] = false;
					boxUsed[row / 3][col / 3][num] = false;
				}
			}

		} else {
			return padding(board, row, col + 1);
		}
		return false;
	}

}
/*编写一个程序，通过已填充的空格来解决数独问题。

一个数独的解法需遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。
一个数独。
答案被标成红色。
*/