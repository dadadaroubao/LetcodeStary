package com.linklist;





public class PartitionList {
	public static void main(String[] args) {//86
		int[] a= {1,4,3,2,5,2};
		ListNode head=createList(a);	
		printList(head);
		ListNode node = partition(head,3);
		printList(node);
	}
	
	 public static ListNode partition(ListNode head, int x) {
		 ListNode minhead=new ListNode(0);
		 ListNode maxhead=new ListNode(0);
		 ListNode minList=minhead;
		 ListNode maxList=maxhead;
		 ListNode node=head;
		 while(node!=null) {
			 if(node.val<x) {
				 minList.next=node;
				 minList=minList.next;
			 }else {
				 maxList.next=node;
				 maxList=maxList.next;
			 }
			 node=node.next;
		 }
		
		 minList.next=maxhead.next;
		 maxList.next=null;
		 return minhead.next;
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
/*给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。

你应当保留两个分区中每个节点的初始相对位置。

示例:

输入: head = 1->4->3->2->5->2, x = 3
输出: 1->2->2->4->3->5
*/


