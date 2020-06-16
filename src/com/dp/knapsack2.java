package com.dp;

import java.util.Arrays;

//完全背包问题
public class knapsack2 {
	//b(2,20)  我背包有20的空间，偷0号到2号商品，最多可以偷多少
	public static void main(String[] args) {
		bag();
		int res=0;
		for(int i=1;i<6;i++) {
			for(int j=1;j<21;j++) {
				if(b[i][j]>res)
					res=b[i][j];
			}
		}
		System.out.println(Arrays.toString(b[5]));
		System.out.println(res);
	}	
	
	private static int[][] b=new int[6][21];//5个商品，背包容量20
	private static int[] w= {0,2,3,4,5,9};
	private static int[] v= {0,3,4,5,8,10};
	
	private static void bag() {
		for(int k=1;k<6;k++) {
			for(int c=1;c<21;c++) {
				int t=0;//每个商品可以无限使用
				while(true) {
					if(t*w[k]<=c) {
						b[k][c]=Math.max(b[k-1][c-w[k]*t]+v[k]*t, b[k-1][c]);
					}
					else
						break;
					t++;
				}
				
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