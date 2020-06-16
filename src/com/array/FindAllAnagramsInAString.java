package com.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
	
	//438

	public static void main(String[] args) {
		String s="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
				+ "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		
		String p="aa";
		List<Integer> list = findAnagrams(s,p);
		System.out.println(list.toString());
	}
	
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> list=new ArrayList<Integer>();
		int l=0;
		int r=p.length()-1;
		while(l<s.length()) {		
			if(r<s.length()&&isContect(s.substring(l, r+1),p)) {
				list.add(l);				
			}
			l++;
			r++;
			
		}
		return list;
	}

	private static boolean isContect(String s, String p) {
		Map<Character, Integer> map=new HashMap<Character, Integer>();
		for(int i=0;i<s.length();i++) {
			if(map.get(s.charAt(i))==null)
				map.put(s.charAt(i), 1);
			else 
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
		}
		for(int i=0;i<p.length();i++) {
			if(map.get(p.charAt(i))==0 || map.get(p.charAt(i))==null) {
				return false;
			}else {
				map.put(p.charAt(i), map.get(p.charAt(i))-1);
			}
		}
		return true;
	}
	



	

public List<Integer> findAnagramsOK(String s, String p) {

       List<Integer> res = new LinkedList<>();
       if (s == null || p == null || s.length() < p.length())
           return res;
       int[] ch = new int[26];
       //统计p串字符个数
       for (char c : p.toCharArray())
           ch[c - 'a']++;
       //把窗口扩成p串的长度
       int start = 0, end = 0, rest = p.length();
       for (; end < p.length(); end++) {
           char temp = s.charAt(end);
           ch[temp - 'a']--;
           if (ch[temp - 'a'] >= 0)
               rest--;
       }
       if (rest == 0)
           res.add(0);
       //开始一步一步向右移动窗口。
       while (end < s.length()) {
           //左边的拿出来一个
           char temp = s.charAt(start);
           if (ch[temp - 'a'] >= 0)
               rest++;
           ch[temp - 'a']++;
           start++;
           //右边的拿进来一个
           temp = s.charAt(end);
           ch[temp - 'a']--;
           if (ch[temp - 'a'] >= 0)
               rest--;
           end++;
           if (rest == 0)
               res.add(start);
       }
       return res;
   }
}
/*给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。

字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。

说明：
if(r+1<s.length() && r-l+1<p.length())
				r++;
			else
				l++;
字母异位词指字母相同，但排列不同的字符串。
不考虑答案输出的顺序。
示例 1:

输入:
s: "cbaebabacd" p: "abc"

输出:
[0, 6]

解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。*/