package com.array;



public class KthLargestElementInAnArray {
	//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
	public static void main(String[] args) {
		int[] nums = {1};
		int num=findKthLargest(nums,1);
		System.out.println(num);
	}

	public static int findKthLargest(int[] nums, int k) {
		
		k=nums.length+1-k;
		int r=nums.length-1;
		int l=0;
		int j=partition(nums,r,l);
		while(r>=l) {
			if(j==k-1) {
				return nums[j];
			}else if(j>k-1) {
				r=j-1;
				j=partition(nums,r,l);
			}else {
				l=j+1;
				j=partition(nums,r,l);
			}
		}
		
		return 0;

    }
	
	public static int partition(int[] nums, int r, int l) {
	    int v=nums[l];
	        int j=l;
	        for(int i=l+1;i<=r;i++){
	            if(nums[i]<v){
	                swep(nums,j+1,i);
	                j++;
	      
	            }
	        }   
	        swep(nums,j,l);
	    
	        return j;
		
	}

	private static void swep(int [] a,int i,int j){
        int temp=a[j];
        a[j]=a[i];
        a[i]=temp;
    }
}
