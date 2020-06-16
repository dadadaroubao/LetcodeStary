package com.backtrack;

public class WordSearch {
	
	public static void main(String[] args) {
		char[][] a= {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		System.out.println(exist(a,"ABCB"));
	}

	static int[][] dir= {{-1,0},{0,1},{1,0},{0,-1}}; //方向
	static int n;
	static int m;
	static boolean[][] b;//判断元素是否已经使用过
	public static boolean exist(char[][] board, String word) {
		n = board.length;
		m = board[0].length;
		b=new boolean[n][m];
		for (int i = 0; i < n; i++) {	
			for (int j = 0; j < m; j++) {
				boolean b = searchword(board, word, 0, i, j);
				if (b)
					return b;
			}
		}
		return false;
	}

	private static boolean searchword(char[][] board, String word, int index, int x, int y) {
		if(index == word.length()-1)
			return board[x][y]==word.charAt(index);
		if(board[x][y]==word.charAt(index)) {//从x，y出发向四周寻找
			b[x][y]=true;
			for(int i=0;i<4;i++) {
				int xx=x+dir[i][0];
				int yy=y+dir[i][1];
				if(xx>=0 && xx<n && yy>=0 && yy<m && !b[xx][yy])
					if(searchword(board,word,index+1,xx,yy))
						return true;
			}
			b[x][y]=false;
		}
		return false;
	}
}
/*给定一个二维网格和一个单词，找出该单词是否存在于网格中。

单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
示例:
board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

给定 word = "ABCCED", 返回 true
给定 word = "SEE", 返回 true
给定 word = "ABCB", 返回 false
*/

