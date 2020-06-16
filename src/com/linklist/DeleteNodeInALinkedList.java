package com.linklist;

public class DeleteNodeInALinkedList {

	private static ListNode head;
	public static void main(String[] args) {
		int[] a= {4,2,1,3};
		head=createList(a);	
		printList(head);
		deleteNode(head.next.next);
		printList(head);
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
	
	public static void deleteNode(ListNode node) {
		if(node==null) {
			return;
		}
		if(node.next==null) {
			node=null;
			return;
		}
        node.val=node.next.val;
        ListNode del=node.next;
        node.next=del.next;
        del=null;
    }
	
}
/*
请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。

现有一个链表 -- head = [4,5,1,9]，它可以表示为:
示例 1:

输入: head = [4,5,1,9], node = 5
输出: [4,1,9]
解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
*/
