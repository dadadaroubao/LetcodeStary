package com.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicatedFromSortedArray2 {
	//对给定的数组去重,相同元素最多保留俩个，返回去重后数组的长度
	public static void main(String[] args) {
		int [] arr= {2,1,2,3,12,2,3};
		int n=f(arr);
		System.out.println(n);
	}

	private static int f(int[] arr) {
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(map.get(arr[i])==null) {
				 map.put(arr[i], 1);
			}else if(map.get(arr[i])<2){
				map.put(arr[i], map.get(arr[i])+1);
			}else {
				arr[i]=0;
				count++;
			}
		}
		System.out.println(map.get(2));
		System.out.println(Arrays.toString(arr));
		return arr.length-count;
	}

}
