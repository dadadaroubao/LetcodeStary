package com.setANDmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	
	public static void main(String[] args) {
		String[] s= {"eat", "tea", "tan", "ate", "nat", "bat"};
	List<List<String>> list = groupAnagrams(s);
	for (List<String> list2 : list) {
		System.out.println(list2.toString());
	}
		
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map=new HashMap<String, List<String>>();
		for (String s : strs) {
			char[] c=s.toCharArray();
			Arrays.sort(c);
			String str=new String(c);
			if(map.containsKey(str)) {
				List<String> arr=map.get(str);
                arr.add(s);
                map.put(str,arr);
			}else {
				List<String> list=new ArrayList<String>();
				list.add(s);
				 map.put(str,list);
			}
		}
		return new ArrayList<>(map.values());
    }
	

}
/*给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
*/
