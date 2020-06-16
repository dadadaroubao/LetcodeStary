package com.array;

public class LongestSubstringWithoutRepeationCharacters {
	/*给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
	输入: "abcabcbb"
	输出: 3 
	解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。*/
	public static void main(String[] args) {
		String s="abcabcbb";
		int n=lengthOfLongestSubstring(s);
		System.out.println(n);
	}
	
	 public static  int lengthOfLongestSubstring(String s) {
		int[] freq= new int[256];
		int l=0;
		int r=-1;
		int res=0;
		while(l<s.length()) {
			
			if(r+1<s.length() && freq[(s.charAt(r+1))]==0) {
				r++;
				freq[(s.charAt(r))]++;
			}else {
				freq[s.charAt(l)]--;
				l++;
			}
			res=Math.max(res, r-l+1);
		}
		return res;

	 }

}
