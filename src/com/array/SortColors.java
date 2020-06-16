package com.array;

import java.util.Arrays;

public class SortColors {

	//给定一个有n个元素的数组，数组中元素的取值只有0，1，2三中可能，为这个数组排序
	public static void main(String[] args) {
		int[] a= {0,1,0,1,2,2,1,0};
		
		sortColors(a);
		System.out.println(Arrays.toString(a));
	}
	
	 public static void sortColors1(int[] nums) {
		 int[] count= {0,0,0};
		 for(int i=0;i<nums.length;i++) {
			 count[nums[i]]++;
		 }
		 int index=0;
		 for(int i=0;i<count[0];i++) {
			 nums[index++]=0;
		 }
		 for(int i=0;i<count[1];i++) {
			 nums[index++]=1;
		 }
		 for(int i=0;i<count[2];i++) {
			 nums[index++]=2;
		 }
	 }
	 
	 public static void sortColors(int[] nums) {
		 
		 int zero=-1; //nums[0...zero]==0
		 int two=nums.length; //nums[two...n-1]==2
		 for(int i=0;i<two;) {
			 if(nums[i]==1)
				 i++;
			 else if(nums[i]==2) {
				 two--;
				 int t=nums[i];
				 nums[i]=nums[two];
				 nums[two]=t;
			 }else {
				 zero++;
				 int t=nums[i];
				 nums[i]=nums[zero];
				 nums[zero]=t;
				 i++;
			 }
			 
		 }
		 
	 }
}
