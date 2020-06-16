package com.backtrack;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

	public static void main(String[] args) {
		String s = "25525511135";
		System.out.println(restoreIpAddresses(s).toString());
	}
	
	static List<String> list = new ArrayList<String>();
	
	public static List<String> restoreIpAddresses(String s) {
		find(0,"",4,s,s.length());
		return list;

    }

	private static void find(int index, String tmp, int flag, String s, int n) {
		if(index==n && flag==0) {
			list.add(tmp.substring(0, tmp.length() - 1));//截去最后一个点
			return;
		}
		if(flag<0)
			return;
		for(int i=index;i<index+3 && i<n;i++) {
			if(i==index && s.charAt(i)=='0') {//不能出现0打头的数字
				find(i+1,tmp+'0'+".",flag-1,s,n);
				break;
			}
			if(Integer.parseInt(s.substring(index, i+1))<=255)
				find(i+1,tmp+s.substring(index, i+1)+".",flag-1,s,n);
		}
		
	}
}
/*给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

示例:

输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]
private void backtrack(int i, String tmp, int flag, String s, List<String> res, int n) {
        if (i == n && flag == 0) {
            res.add(tmp.substring(0, tmp.length() - 1));
            return;
        }
        if (flag < 0) return;
        for (int j = i; j < i + 3; j++) {
            if (j < n) {
                if (i == j && s.charAt(j) == '0') {
                    backtrack(j + 1, tmp + s.charAt(j) + ".", flag - 1, s, res, n);
                    break;
                }
                if (Integer.parseInt(s.substring(i, j + 1)) <= 255)
                    backtrack(j + 1, tmp + s.substring(i, j + 1) + ".", flag - 1, s, res, n);
            }
        }
    }

作者：powcai
链接：https://leetcode-cn.com/problems/restore-ip-addresses/solution/bao-li-he-hui-su-by-powcai/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
*/
