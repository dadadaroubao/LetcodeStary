package com.array;

import java.util.Arrays;

public class MoveZeros {//把所有0挪到数组末尾

	public static void main(String[] args) {
	    int [] arr= {0,1,0,3,12};//
		int[] a=f1(arr);
	    a=f2(arr);
		a=f3(arr);
		System.out.println(Arrays.toString(a));//结果应为{1,3,12,0,0}
	}

	
	
     private static int[] f1(int[] arr) {
    	 int[] nonoZero=new int[arr.length];
    	 int t=0;
    	 for(int i=0;i<arr.length;i++) {
    		 if(arr[i]!=0) {
    			 nonoZero[t]=arr[i];
    			 t++;
    		 }
    	 }
    	 arr=nonoZero;
		return arr;
     }
     
     private static int[] f2(int[] arr) {
    	int k=0;//非0元素的索引
    	for(int i=0;i<arr.length;i++) {
    		if(arr[i]!=0) {
    			arr[k]=arr[i];
    			k++;
    		}
    	}
    	for(int i=k;i<arr.length;i++) {//让其他位置值为0
    		arr[i]=0;
    	}
    	 
		return arr;  	 
     }
     
     private static int[] f3(int[] arr) {
     	int k=0;//非0元素的索引
     	//k以后都为0元素
     	for(int i=0;i<arr.length;i++) {
     		if(arr[i]!=0) {
     			if(i!=k) {
     				//交换
     				int t=arr[i];
     				arr[i]=arr[k];
     				arr[k]=t;
     				k++;
     			}else {
     				k++;
     			}
     		}
     	}
     	 
 		return arr;  	 
      }
}
