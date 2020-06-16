package com.setANDmap;

import java.util.HashMap;
import java.util.Map;

public class Sum4Ⅱ {
	public static void main(String[] args) {
		int[] a= {1, 2};
		int[] b= {-2,-1};
		int[] c= {-1,2};
		int[] d= {0,2};
		System.out.println(fourSumCount(a,b,c,d));
	}
	
	public static  int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<C.length;i++) 
			for(int j=0;j<D.length;j++) {
				if(map.get(C[i]+D[j])!=null)
					map.put(C[i]+D[j], map.get(C[i]+D[j])+1);
				else
					map.put(C[i]+D[j], 1);
			}
		int res=0;
		for(int i=0;i<A.length;i++) 
			for(int j=0;j<B.length;j++) {
				if(map.get(0-A[i]-B[j])!=null && map.get(0-A[i]-B[j])!=0 ) 
					res+=map.get(0-A[i]-B[j]);		
			}
		return res;
    }

}
/*给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。

为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。

例如:

输入:
A = [ 1, 2]
B = [-2,-1]
C = [-1, 2]
D = [ 0, 2]

输出:
2  */

