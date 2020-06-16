package com.backtrack;

public class NumberOfIslands {//floodfill方法
	
	public static void main(String[] args) {
		char[][] a= {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}; 
		System.out.println(numIslands(a));
	}
	
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 方向
	static int n;
	static int m;
	static boolean[][] b;// 判断元素是否已经使用过

	public static int numIslands(char[][] grid) {
		n = grid.length;
        int sum = 0;
        if (n == 0)
			return sum;
		m = grid[0].length;
		b = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!b[i][j] && grid[i][j] == '1') {
					sum++;
					dfs(grid, i, j);
				}
			}
		}
		return sum;
	}

	private static void dfs(char[][] grid, int x, int y) {
		b[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int xx = x + dir[i][0];
			int yy = y + dir[i][1];
			if (xx >= 0 && xx < n && yy >= 0 && yy < m && !b[xx][yy] && grid[xx][yy] == '1')
				dfs(grid, xx, yy);
		}
	}

}
/*给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。

岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。

此外，你可以假设该网格的四条边均被水包围。

示例 1:

输入:
11110
11010
11000
00000
输出: 1

示例 2:

输入:
11000
11000
00100
00011
输出: 3
解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
*/
