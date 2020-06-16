package com.setANDmap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IntersectionOfTwoArrays {

	public static void main(String[] args) {
		int[] n1= {1,2,2,1};
		int[] n2= {2,2};
		int[] n=intersection(n1, n2);
		System.out.println(Arrays.toString(n));
	}
	
	public static int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> set=new HashSet<Integer>();
		for(int i=0;i<nums1.length;i++) {
			set.add(nums1[i]);
		}
		Set<Integer> resultset=new HashSet<Integer>();
		for(int i=0;i<nums2.length;i++) {
			if(set.contains(nums2[i])) {
				resultset.add(nums2[i]);
			}
		}
		int[] n=new int[resultset.size()];
		Iterator<Integer> it=resultset.iterator();
		for(int i=0;i<resultset.size();i++) {
			n[i]=it.next();
		}
		return n;
    }
}
/*给定两个数组，编写一个函数来计算它们的交集。
输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2] */