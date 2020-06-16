package com.linklist;

public class SwapNodesInPairs {
	public static void main(String[] args) {
		int[] a= {1,2,3,4,5};
		ListNode head=createList(a);	
		printList(head);
		ListNode node = swapPairs(head);
		printList(node);
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
	

	public static ListNode swapPairs(ListNode head) {
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		ListNode p=dummy;
		while(p.next!=null && p.next.next!=null) {
			ListNode cur1=p.next;
			ListNode cur2=cur1.next;
			ListNode next=cur2.next;
			cur2.next=cur1;
			cur1.next=next;
			p.next=cur2;
			p=cur1;	
		}
		return dummy.next;
    }
}
/*给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
示例:

给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
