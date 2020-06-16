package com.queueANDstack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public static void main(String[] args) {
		int[] n = { 1, 1, 1, 2, 2, 3 ,4,4,4};
		System.out.println(topKFrequent(n, 2).toString());
	}

	public static List<Integer> topKFrequent(int[] nums, int k) {
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
		for (int n : nums) {
			count.put(n, count.getOrDefault(n, 0) + 1);
		}
		//使用最小堆实现优先队列
		PriorityQueue<Integer> queue=new PriorityQueue<Integer>((n1,n2)-> count.get(n1)-count.get(n2));

		for (int n : count.keySet()) {
			queue.add(n);
			if (queue.size() > k)//维护优先队列
				queue.poll();
		}
		
		List<Integer> list=new ArrayList<Integer>();
		while(!queue.isEmpty()) {
			list.add(queue.poll());
		}
		Collections.reverse(list);
		return list;
	}
}
/*给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
*/
