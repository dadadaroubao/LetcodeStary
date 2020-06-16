package com.linklist;

import java.util.HashMap;
import java.util.Map;



public class RemoveDuplicatesFromSortedList {
	public static void main(String[] args) {
		int[] a= {1,1,3,4,5};
		ListNode head=createList(a);	
		printList(head);
		ListNode node = deleteDuplicates(head);
		printList(node);
	}
	
	public static ListNode deleteDuplicates(ListNode head) {
		ListNode node=head;
		ListNode pro=null;
		Map<Integer,Integer> map=new HashMap<Integer, Integer>();
		while(node!=null) {
			if(map.containsKey(node.val)) {
				node=node.next;
				pro.next=node;
			}else {
				map.put(node.val, 1);
				pro=node;
				node=node.next;
			}		
		}
		return head;
    }
	
	public static ListNode createList(int[] a) {
		int n=a.length;
		if(n==0)
			return null;
		ListNode head=new ListNode(a[0]);
		ListNode node=head;
		for(int i=1;i<a.length;i++) {
			node.next=new ListNode(a[i]);
			node=node.next;
		}
		return head;
	}
	
	public static void printList(ListNode head) {
		ListNode node=head;
		while(node!=null) {
			System.out.print(node.val+"->");
			node=node.next;
		}
		System.out.print("null"+"\n");
	}

}
/*给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2
输出: 1->2
示例 2:

输入: 1->1->2->3->3
输出: 1->2->3*/


