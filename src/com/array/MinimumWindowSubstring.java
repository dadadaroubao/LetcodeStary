package com.array;

public class MinimumWindowSubstring {

	//76
	public static void main(String[] args) {
		String s="ADOBECODEBANC";
		String t="ABC";
		String ss=minWindow(s,t);
		System.out.println(ss);
	}
	
	public static String minWindow(String s, String t) {
		 String res="";
	     if(s.length()<t.length())//边界情况
	          return res;
	     int[] num=new int[256];
	     for(int i=0;i<t.length();i++) {
	    	 num[t.charAt(i)]++;
	     }
	     int left=0,count=t.length(),max=s.length()+1;
	     for(int r=0;r<s.length();r++) {//相当于右指针
	    	
	    	 num[s.charAt(r)]--;//如果s[r]没在t中出现，则变为-1
	    	 if(num[s.charAt(r)]>=0)//s[r]在t中出现,匹配到一个字母，计数变量-1
	    		 count--;    	 
	    	//当left指向的字母是多余的，则将left右移
	        //并在hash数组中加上之前减去的left位置的字母
	    	 while(left<r && num[s.charAt(left)]<0){
	    		 num[s.charAt(left)]++;
	             left++;
	         }
	    	//count==0说明找到了包含t的子串，max用来衡量是否是最小子串
	        if(count==0 && max>r-left+1){
	            max=r-left+1;
	            res=s.substring(left,r+1);//将子串保存到结果中,从left开始，长度为max的子串
	        }
	     }
	     
	     return res;
    }
}
/*给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。

示例：

输入: S = "ADOBECODEBANC", T = "ABC"
输出: "BANC"
说明：

如果 S 中不存这样的子串，则返回空字符串 ""。
如果 S 中存在这样的子串，我们保证它是唯一的答案。*/