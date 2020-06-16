package com.array;

public class ValidPalindrome {

	//125 给定一个字符串，只看其中的数字和字母，忽略大小写，判断字符串是否为回文串
	
	public static void main(String[] args) {
		String s="A man, a plan, a canal: Panama";
		
		System.out.println(s);
		boolean b = isPalindrome(s);
		System.out.println(b);
	}
	
	 public static boolean isPalindrome(String s) {
		 if(s.length()<1) {
			 return true;
		 }
		 s=s.toLowerCase();
		 int start=0;
		 int end=s.length()-1;
		 while(start<end) {
			 while(start<end&&!IsCharOrNumber(s.charAt(start)))
	                start++;
	         while(start<end&&!IsCharOrNumber(s.charAt(end)))
	                end--;
	         if(s.charAt(start) != s.charAt(end)) {
	        	 return false;
	         }
	         start++;
	         end--;
		 }
		return true;

	 }

	private static boolean IsCharOrNumber(char s) {
        if((s>='a'&&s<='z')||(s>='0'&&s<='9'))
            return true;
		return false;
	}
}
