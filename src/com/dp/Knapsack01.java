package com.dp;

public class Knapsack01 {

	public static void main(String[] args) {
		System.out.println(knapsack2_3());
	}
	
	private static int[][] memo=new int[5][21];//5个商品，背包容量20
	private static int[] w= {2,3,4,5,9};
	private static int[] v= {3,4,5,8,10};
	
	//dp
	public static int knapsack2() {
		int n = w.length;
		for (int j = 0; j < 21; j++)
			memo[0][j] = (j >= w[0] ? v[0] : 0);
		for (int i = 1; i < n; i++)
			for (int j = 0; j < 21; j++) {
				memo[i][j] = memo[i - 1][j];
				if (j >= w[i])
					memo[i][j] = Math.max(memo[i][j], v[i] + memo[i - 1][j - w[i]]);
			}
		return memo[n - 1][20];
	}
	
	//dp优化
	public static int knapsack2_3() {
		int n = w.length;
		int[] a = new int[21];
		for (int j = 0; j < 21; j++)
			a[j] = (j >= w[0] ? v[0] : 0);
		for (int i = 1; i < n; i++)
			for (int j = 20; j >= w[i]; j--) {
				a[j] = Math.max(a[j], v[i] + a[j - w[i]]);
			}
		return a[20];
	}
	
	// dp优化
	public static int knapsack2_2() {
		int n = w.length;
		for (int j = 0; j < 21; j++)
			memo[0][j] = (j >= w[0] ? v[0] : 0);
		for (int i = 1; i < n; i++)
			for (int j = 0; j < 21; j++) {
				memo[i % 2][j] = memo[(i - 1) % 2][j];
				if (j >= w[i])
					memo[i % 2][j] = Math.max(memo[i % 2][j], v[i] + memo[(i - 1) % 2][j - w[i]]);
			}
		return memo[(n - 1) % 2][20];
	}

	//递归和记忆化搜索
	public static int knapsack() {
		int n=w.length;
		return bestValue(n-1,20);
	}

	private static int bestValue(int index, int c) {//商品索引和背包容量
		if(index<0 || c<=0)
			return 0;
		if(memo[index][c]!=0)
			return memo[index][c];
		int res=bestValue(index-1, c);
		if(c>=w[index])
			res=Math.max(res, v[index]+bestValue(index-1, c-w[index]));
		memo[index][c]=res;
		return res;
	}
	
}
/*
重(w)   价（v） 
2      	3
3	    4
4      	5
5	    8
9	    10
包能装20，如何装价格最高
*/