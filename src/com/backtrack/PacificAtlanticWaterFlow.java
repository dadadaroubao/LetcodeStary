package com.backtrack;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

	public static void main(String[] args) {
		int[][] a= {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}; 
		//int[][] a= {{1,1},{1,1},{1,1}};
 		System.out.println(pacificAtlantic(a).toString());
	}
	
	static int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } }; // 方向
	static int n;
	static int m;
	static List<List<Integer>> list;
	public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
		n=matrix.length;
		list=new ArrayList<List<Integer>>();
		if(n==0)
			return list;
		m=matrix[0].length;
		boolean[][]reachP=new boolean[n][m];//表示可以流向太平洋
        boolean[][]reachA=new boolean[n][m];
		for (int i = 0; i < n; i++) {
			dfs(matrix,i,0,reachP);
			dfs(matrix,i,m-1,reachA);			
		}
		for (int i = 0; i < m; i++) {
			dfs(matrix,0,i,reachP);
			dfs(matrix,n-1,i,reachA);			
		}
		for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(reachP[i][j]&&reachA[i][j]){
                    List<Integer> tmp=new ArrayList<>();
                    tmp.add(i);
                    tmp.add(j);
                    list.add(tmp);
                }
            }
		}
		return list;
    }
	private static void dfs(int[][] matrix, int x, int y, boolean[][] reach) {
		//System.out.println(x+"="+y);
		reach[x][y]=true;
		for (int i = 0; i < 4; i++) {
			int xx = x + dir[i][0];
			int yy = y + dir[i][1];
			if (xx >= 0 && xx < n && yy >= 0 && yy < m && !reach[xx][yy] && matrix[xx][yy] >=matrix[x][y] )
				dfs(matrix, xx, yy,reach);
		}
	}
	
}
/*给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。

规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。

请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。

 

提示：

输出坐标的顺序不重要
m 和 n 都小于150
 

示例：

 

给定下面的 5x5 矩阵:

  太平洋 ~   ~   ~   ~   ~ 
       ~  1   2   2   3  (5) *
       ~  3   2   3  (4) (4) *
       ~  2   4  (5)  3   1  *
       ~ (6) (7)  1   4   5  *
       ~ (5)  1   1   2   4  *
          *   *   *   *   * 大西洋

返回:

[[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
*/
