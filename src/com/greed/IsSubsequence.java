package com.greed;

public class IsSubsequence {

	public static void main(String[] args) {
		System.out.println(isSubsequence("abc","ahbgdc"));
	}
	
	public static boolean isSubsequence(String s, String t) {
		int n1=s.length();
		int n2=t.length();
		if(n1>n2)
			return false;
		char[] a1 = s.toCharArray();
		char[] a2 = t.toCharArray();
		int x1=0;
		int x2=0;
		while(x1<n1 && x2<n2) {
			if(a1[x1]==a2[x2]) {
				x1++;
				x2++;
			}else {
				x2++;
			}
		}
		return x1==n1;
    }
}
/*给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。

字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

示例 1:
s = "abc", t = "ahbgdc"

返回 true.

示例 2:
s = "axc", t = "ahbgdc"

返回 false.
*/
