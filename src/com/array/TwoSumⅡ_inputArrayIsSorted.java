package com.array;

public class TwoSumⅡ_inputArrayIsSorted {

	//给定一个有序整性数组和一个整数t，找出俩个元素和为t，返回这两个数的索引
	public static void main(String[] args) {
		int[] numbers= {2,7,11,15};
		int[] n=twoSum(numbers,9);
		System.out.println(n[1]+" == "+n[0]);
	}
	
	public static int[] twoSum(int[] numbers, int target) {
		int l=0;
		int r=numbers.length-1;
		while(r>l) {
			if(numbers[l]+numbers[r]==target) {
				int[] index= {l+1,r+1};
				return index;
			}else if(numbers[l]+numbers[r]>target) {
				r--;
			}else {
				l++;
			}
		}
		return null;

    }
}
