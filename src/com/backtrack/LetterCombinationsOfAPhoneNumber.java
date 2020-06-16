package com.backtrack;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	public static void main(String[] args) {
		//String s = "23";
		System.out.println(letterCombinations("").toString());
	}

	static String[] a = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
	static List<String> list = new ArrayList<String>();

	public static List<String> letterCombinations(String digits) {
		  if(digits.equals(""))
			return list;
		find(digits, 0, "");
		return list;
	}

	public static void find(String digits, int index, String s) {
		if (index == digits.length()) {
			list.add(s);
			return;
		}
		char c = digits.charAt(index);
		String letters = a[c - '0'];// 找到数字对应的字符串
		for (int i = 0; i < letters.length(); i++)
			find(digits, index + 1, s + letters.charAt(i));
	}

}
/*给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*/
