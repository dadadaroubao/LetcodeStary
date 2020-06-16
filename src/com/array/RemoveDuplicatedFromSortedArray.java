package com.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatedFromSortedArray {
	//对给定的数组去重，返回去重后数组的长度
	public static void main(String[] args) {
		int [] arr= {2,1,2,3,12};
		int n=f(arr);
		System.out.println(n);
	}

	private static int f(int[] arr) {
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(map.get(arr[i])!=null) {
				arr[i]=0;
				count++;
			}else {
				 map.put(arr[i], 1);
			}
		}
		System.out.println(Arrays.toString(arr));
		return arr.length-count;
	}

}
