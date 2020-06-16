package com.array;

public class RemoveElement {
	//给定数组和一个值，将等于值的元素删除，返回剩余元素个数
	public static void main(String[] args) {
		int [] arr= {2,1,2,3,12};
		int num=2;
		int a=f(arr,num);
		System.out.println(a);
	}

	private static int f(int[] arr, int num) {
		int count=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == num) {
				arr[i]=0;
				count++;
			}
		}
		return arr.length-count;
	}

}
