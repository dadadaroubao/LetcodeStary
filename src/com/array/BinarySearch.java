package com.array;

import java.util.Arrays;

public class BinarySearch {//二分搜索法
	public static void main(String[] args) {
		int [] a= {1,4,7,6,9,2,5,11,3,45,98,46,31,32,47,98};
		Arrays.sort(a);
		int index=f(a,98);
		System.out.println(index);
	}

	private static int f(int[] a, int m) {
		int l=0;
		int r=a.length-1;//在[l,r]中寻找m
		while(l<=r) {
			System.out.println("++++");
			int mid=(r-l)/2+l;
			if(m>a[mid]) {
				l=mid+1;
			}else if(m<a[mid]) {
				r=mid-1;
			}else {//找到索引
				return mid;
			}
		}
		return -1;
	}
	
}
