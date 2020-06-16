package com.array;

import java.util.Arrays;

public class MergeSortedArray {
	public static void main(String[] args) {//合并俩个有序序列
		int[] nums1 = {1,2,3,0,0,0,0};
		int[] nums2 = {2,5,6};
		merge(nums1,3,nums2,3);
		System.out.println(Arrays.toString(nums1));
	}
	
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		n=n-1;
		m=m-1;
		for(int i=m+n+1;i>=0;i--) {
			if(n<0 || (m>=0 && nums1[m]>=nums2[n])) {
				nums1[i]=nums1[m];
				m--;
			}else if(m<0 || nums1[m]<nums2[n]){
				nums1[i]=nums2[n];
				n--;
			}
		}
		
    }
}
