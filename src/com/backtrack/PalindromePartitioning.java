package com.backtrack;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
	public static void main(String[] args) {
		String s = "a";
		System.out.println(partition(s));
	}

	static List<List<String>> list ;
	static int n;

	public static List<List<String>> partition(String s) {
		List<String> tmp = new ArrayList<String>();
		list= new ArrayList<>();
		n = s.length();
		find(s, 0, tmp);
		return list;

	}

	private static void find(String s, int index, List<String> tmp) {
		if (index == n) {
			list.add(new ArrayList<String>(tmp));
			return;
		}
		for (int i = index; i < n; i++) {
			if (isPalindrome(s, index, i)) {// 判断是否为回文
				tmp.add(s.substring(index, i + 1));
				find(s, i + 1, tmp);
				tmp.remove(tmp.size() - 1);
			}
		}

	}

	private static boolean isPalindrome(String s, int begin, int end) {
		while (end > begin) {
			if (s.charAt(begin) != s.charAt(end))
				return false;
			begin++;
			end--;
		}
		return true;
	}

}
/*
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 
 * 返回 s 所有可能的分割方案。
 * 
 * 示例:
 * 
 * 输入: "aab" 输出: [ ["aa","b"], ["a","a","b"] ]
 */
