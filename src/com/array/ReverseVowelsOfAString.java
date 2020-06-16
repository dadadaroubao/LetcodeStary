package com.array;



public class ReverseVowelsOfAString {

	//345 给定一个字符串，将该字符串的元音字母翻转
	
	public static void main(String[] args) {
		String s="hello";
		String ss=reverseVowels(s);
		System.out.println(ss);
	}
	
	 public static String reverseVowels(String s) {
		 char[] a=s.toCharArray();
		 int start=0;
		 int end=s.length()-1;
		 while(start<end) {
			 while(start<end&&!IsVowe(a[start]))
	                start++;
	         while(start<end&&!IsVowe(a[end]))
	                end--;
	         char t=a[start];
	         a[start]=a[end];
	         a[end]=t;
	         start++;
	         end--;
		 }
		return String.valueOf(a);
	    }

	private static boolean IsVowe(char s) {
		if(s=='a' || s=='e' ||s=='i' ||s=='o' ||s=='u' || s=='A' || s=='E' ||s=='I' ||s=='O' ||s=='U')
			return true;
		return false;
	}
}
