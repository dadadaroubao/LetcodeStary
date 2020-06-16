package com.setANDmap;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
	
	public static void main(String[] args) {
		String s1="";
		String s2="";
		boolean b = isAnagram(s1,s2);
		System.out.println(b);
	}

	 public static boolean isAnagram(String s, String t) {
		 if(s.length()!=t.length())
			 return false;
		 if(s.length()==0)
			 return true;
		 Map<Character, Integer> map=new HashMap<Character, Integer>();
		 for(int i=0;i<s.length();i++) {
			 if(map.get(s.charAt(i))==null)
					map.put(s.charAt(i),1);
			 else 
					map.put(s.charAt(i),map.get(s.charAt(i))+1);
		 }
		 for(int i=0;i<t.length();i++) {
			 if(map.get(t.charAt(i))!=null && map.get(t.charAt(i))>0) {
					map.put(t.charAt(i),map.get(t.charAt(i))-1);
			 }else {
				return false; 
			 }
		 }
		return true;
	    }
}
/* 242 
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true

 * */
 