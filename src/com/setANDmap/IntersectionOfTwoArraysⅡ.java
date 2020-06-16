package com.setANDmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class IntersectionOfTwoArraysⅡ {

	public static void main(String[] args) {
		int[] n1= {4,7,9,7,6,7};
		int[] n2= {5,0,0,6,1,6,2,2,4};
		int[] n=intersect(n1, n2);
		System.out.println(Arrays.toString(n));
	}
	public static int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<nums1.length;i++) {
			if(map.get(nums1[i])==null)
				map.put(nums1[i],1);
			else 
				map.put(nums1[i],map.get(nums1[i])+1);
		}
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<nums2.length;i++) {
			if(map.get(nums2[i])!=null && map.get(nums2[i])>0) {
				list.add(nums2[i]);
				map.put(nums2[i],map.get(nums2[i])-1);
			}
		}
		int[] n=new int[list.size()];
		for(int i=0;i<n.length;i++) {
			n[i]=list.get(i);
		}
		return n;
    }
}
/*给定两个数组，编写一个函数来计算它们的交集。
输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2] */