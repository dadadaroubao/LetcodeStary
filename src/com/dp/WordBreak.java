package com.dp;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
	
	public static void main(String[] args) {
		List<String> list=new ArrayList<String>();
		list.add("apple");
		list.add("pen");
		System.out.println(wordBreak("applepenapple",list));
	}
	
	public static boolean wordBreak(String s, List<String> wordDict) {
		int n=s.length();
		if(n==0)
			return false;
		boolean[] dp=new boolean[n+1];
		dp[0]=true;
		for(int i=1;i<=n;i++) {
			for (String str : wordDict) {
				int len=str.length();
				if(i>=len && dp[i-len]==true &&s.substring(i-len, i).equals(str)) {
					dp[i]=true;
					break;
				}
			}
		}
		return dp[n];
    }

}
/*给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
     注意你可以重复使用字典中的单词。
示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
*/

