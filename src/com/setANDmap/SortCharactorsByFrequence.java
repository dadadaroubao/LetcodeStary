package com.setANDmap;


import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class SortCharactorsByFrequence {

	
	public static void main(String[] args) {
		String s="eert";
		System.out.println(frequencySort(s));
	}
	 
	public static String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i=0;i<s.length();i++) {
			if(map.containsKey(s.charAt(i)))
				map.put(s.charAt(i), map.get(s.charAt(i))+1);
			else
				map.put(s.charAt(i), 1);
		}
		//将不同字符按照出现的次数进行重组字符串,并放到数组中
				String[] strs = new String[map.size()];
				int i = 0;
				for ( Entry<Character, Integer> entrty : map.entrySet()) {
					
					StringBuilder sb = new StringBuilder();
					
					for (int j = 0; j < entrty.getValue(); j++) {
						sb.append(entrty.getKey());
					}
					
					strs[i] = sb.toString();
					i++;
				}
				//System.out.println(Arrays.toString(strs));
				
				//遍历数组中的字符串,按照字符串的长度进行排序,也就是按出现频率进行排序
				for (int j = 0; j < strs.length-1; j++) {
					for (int k = j+1; k < strs.length; k++) {
						
						if(strs[j].length() < strs[k].length()) {
							String t= strs[j];
							strs[j] = strs[k];
							strs[k] = t;
						}
					}
				}
				//System.out.println(Arrays.toString(strs));
				//将排序之后的字符串数组中的字符重新组装成字符串返回
				StringBuilder rs = new StringBuilder();
				for (int j = 0; j < strs.length; j++) {
					rs.append(strs[j]);
				}
				
				return rs.toString();
	
	    }
}


/*给定一个字符串，请将字符串里的字符按照出现的频率降序排列。

示例 1:

输入:
"tree"

输出:
"eert"

解释:
'e'出现两次，'r'和't'都只出现一次。
因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
示例 2:

输入:
"cccaaa"

输出:
"cccaaa"

解释:
'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
注意"cacaca"是不正确的，因为相同的字母必须放在一起。
示例 3:

输入:
"Aabb"

输出:
"bbAa"

解释:
此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
注意'A'和'a'被认为是两种不同的字符。 */
