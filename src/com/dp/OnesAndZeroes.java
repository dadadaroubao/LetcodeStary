package com.dp;

public class OnesAndZeroes {
	
	public static void main(String[] args) {
		String[] s= {"10", "0001", "111001", "1", "0"};
		System.out.println(findMaxForm(s,5,3));
	}
	
	public static int findMaxForm(String[] strs, int m, int n) {
		  if(strs.length==0 || strs==null || (m==0 && n==0))
			return 0;
		int[][] dp=new int[m+1][n+1];
		for(int i=0;i<strs.length;i++) {
			int num0=0;
			int num1=0;
			String s=strs[i];
			for(int j=0;j<s.length();j++) {
				if(s.charAt(j)=='0')
					num0++;
				else 
					num1++;
			}
			for(int j=m;j>=num0;j--)
				for(int k=n;k>=num1;k--)
					dp[j][k]=Math.max(dp[j][k], 1+dp[j-num0][k-num1]);
		}
		return dp[m][n];
	}

}
/*在计算机界中，我们总是追求用有限的资源获取最大的收益。

现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。

你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。

注意:

给定 0 和 1 的数量都不会超过 100。
给定字符串数组的长度不会超过 600。
示例 1:

输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
输出: 4

解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
示例 2:

输入: Array = {"10", "0", "1"}, m = 1, n = 1
输出: 2

解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
*/