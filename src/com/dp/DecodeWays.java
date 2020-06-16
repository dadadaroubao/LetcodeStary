package com.dp;

import java.util.Arrays;

public class DecodeWays {
	
	public static void main(String[] args) {
		System.out.println(numDecodings("11010"));
	}
	
	 public static int numDecodings(String s) {
		 int n=s.length();
		 char[] arr = s.toCharArray();
		 int[] dp=new int[n+1]; 
		 dp[0]=1;
		 dp[1] = arr[0]=='0'?0:1;//一个字符只有一个或0个可能
		 if(n<=1)
			 return dp[1];
		 for(int i=2;i<=n;i++) {
			 int tmp = (arr[i-2]-'0')*10+(arr[i-1]-'0');
			 if(arr[i-2]=='0'  && arr[i-1]=='0') {
				 return 0;//当输入为00时，返回0
			 }else if(arr[i-2]=='0') {
				 dp[i]=dp[i-1];
			 }else if(arr[i-1]=='0') {
				 if(tmp>26)
					 return 0;
				 dp[i]=dp[i-2];
			 }else if(tmp>26) {
				 dp[i]=dp[i-1];
			 }else {
				 dp[i]=dp[i-1]+dp[i-2];
			 }
			 
		 }
		 System.out.println(Arrays.toString(dp));
		return dp[n];    
	 }

}
/*一条包含字母 A-Z 的消息通过以下方式进行了编码：

'A' -> 1
'B' -> 2
...
'Z' -> 26
给定一个只包含数字的非空字符串，请计算解码方法的总数。

示例 1:

输入: "12"
输出: 2
解释: 它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2:

输入: "226"
输出: 3
解释: 它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
*/
