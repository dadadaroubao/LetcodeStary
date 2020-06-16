package com.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BinaryWatch {
	public static void main(String[] args) {
		System.out.println(readBinaryWatch(2).toString());
	}
	
	static List<String> list;
	public static List<String> readBinaryWatch(int num) {
		
		list = new ArrayList<String>();
		list.clear();
		helpMy(num,0,0,1,1, new LinkedList<Integer>(), new LinkedList<Integer>());
		System.out.println(list.size());
		return list;
    }

	private static void helpMy(int num, int h, int m, int Hindex, int Mindex, LinkedList<Integer> Hlist,
			LinkedList<Integer> Mlist) {
		if (Hlist.size() + Mlist.size() == num) {          
            	list.add(String.format("%d:%02d", h, m));    
			return;
		}
		for (int i = Hindex; i <= 8; i <<= 1) {
			Hlist.addLast(i);
			h += i;
			help(num, h, m, i << 1, 1, Hlist, Mlist);
			Hlist.removeLast();
			h -= i;
		}
		for (int i = Mindex; i <= 32; i <<= 1) {
			Mlist.addLast(i);
			m += i;
			help(num, h, m, 16, i << 1, Hlist, Mlist);//不重复走第一个for循环
			Mlist.removeLast();
			m -= i;
		}

	}
	
	private static void help(int num, int h, int m, int Hindex, int Mindex, LinkedList<Integer> Hlist,
			LinkedList<Integer> Mlist) {
		if (Hlist.size() + Mlist.size() == num) {
			if (h < 12 && m < 60)
			list.add(String.format("%d:%02d", h, m));
			return;
		}
		for (int i = Hindex; i <= 8; i <<= 1) {
			Hlist.addLast(i);
			
			help(num, h+i, m, i << 1, 1, Hlist, Mlist);
			Hlist.removeLast();
			
		}
		for (int i = Mindex; i <= 32; i <<= 1) {
			Mlist.addLast(i);
			
			help(num, h, m+i, 16, i << 1, Hlist, Mlist);//不重复走第一个for循环
			Mlist.removeLast();
			
		}

	}

}
/*二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。

每个 LED 代表一个 0 或 1，最低位在右侧。

例如，上面的二进制手表读取 “3:25”。

给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。

案例:

输入: n = 1
返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
*/
