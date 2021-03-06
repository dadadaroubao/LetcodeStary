package com.dp;

public class LongestCommonSequence {
	
	public static void main(String[] args) {
		String s1="abcde";
		String s2="aebd";
		System.out.println(longestCommonSubsequence(s1,s2));
	}
	
	public static int longestCommonSubsequence(String text1, String text2) {
		char [] chars_text1=text1.toCharArray();
        char [] chars_text2=text2.toCharArray();
        int n1=chars_text1.length;
        int n2=chars_text2.length;
        //到text1的i和到text2的j位置公共子序列的长度
        int[][] dp=new int[n1+1][n2+1];
        for(int i=1;i<=n1;i++)
        	for(int j=1;j<=n2;j++) {
        		if(chars_text1[i-1]==chars_text2[j-1]) dp[i][j]=dp[i-1][j-1]+1;
                else if(dp[i][j-1]>=dp[i-1][j]) dp[i][j]=dp[i][j-1];
                else dp[i][j]=dp[i-1][j];   
        	}
		return dp[n1][n2];
	}

}
/*给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。

一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。

若这两个字符串没有公共子序列，则返回 0。

 

示例 1:

输入：text1 = "abcde", text2 = "ace" 
输出：3  
解释：最长公共子序列是 "ace"，它的长度为 3。
示例 2:

输入：text1 = "abc", text2 = "abc"
输出：3
解释：最长公共子序列是 "abc"，它的长度为 3。
示例 3:

输入：text1 = "abc", text2 = "def"
输出：0
解释：两个字符串没有公共子序列，返回 0。
*/
