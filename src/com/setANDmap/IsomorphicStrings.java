package com.setANDmap;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
	
	public static void main(String[] args) {
		String s="ab";
		String t="aa";
		System.out.println(isIsomorphic(s,t));
	}
	
	public static  boolean isIsomorphic(String s, String t) {
		if(s == null || t==null) return false;
	    Map<Character, Character> map1 = new HashMap<>();
	    Map<Character, Character> map2 = new HashMap<>();
	    int len=s.length();
	    for(int i=0;i<len;++i) {
	    	if(map1.containsKey(s.charAt(i)) || map2.containsKey(t.charAt(i))) {
	    		if(map1.get(s.charAt(i))==null || map2.get(t.charAt(i))==null||map1.get(s.charAt(i))!=t.charAt(i) || map2.get(t.charAt(i))!=s.charAt(i))
	    			return false;
	    	}else {
	    		map1.put(s.charAt(i), t.charAt(i));
	    		map2.put(t.charAt(i), s.charAt(i));
	    	}
	    }
		return true;
    }

}
/*给定两个字符串 s 和 t，判断它们是否是同构的。

如果 s 中的字符可以被替换得到 t ，那么这两个字符串是同构的。

所有出现的字符都必须用另一个字符替换，同时保留字符的顺序。两个字符不能映射到同一个字符上，但字符可以映射自己本身。

示例 1:

输入: s = "egg", t = "add"
输出: true
示例 2:

输入: s = "foo", t = "bar"
输出: false
示例 3:

输入: s = "paper", t = "title"
输出: true  */

