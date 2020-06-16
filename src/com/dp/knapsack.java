package com.dp;
//01背包问题
public class knapsack {
	//b(2,20)  我背包有20的空间，偷0号到2号商品，最多可以偷多少
	public static void main(String[] args) {
		bag();
		System.out.println(b[5][20]);
	}	
	
	private static int[][] b=new int[6][21];//5个商品，背包容量20
	private static int[] w= {0,2,3,4,5,9};
	private static int[] v= {0,3,4,5,8,10};
	
	private static void bag() {
		for(int k=1;k<6;k++) {
			for(int c=1;c<21;c++) {
				if(w[k]>c)
					b[k][c]=b[k-1][c];
				else
					b[k][c]=Math.max(b[k-1][c-w[k]]+v[k], b[k-1][c]);
			}
		}
	}
}
/*重(w)   价（v）
 2      3
 3	    4
 4      5
 5	    8
 9	    10
包能装20，如何装价格最高*/