package com.linklist;

public class ReverseLinkedList {

	public static void main(String[] args) {
		int[] a= {1,2,3,4,5};
		ListNode head=createList(a);	
		printList(head);
		ListNode node = reverseList(head);
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
	
	public static ListNode reverseList(ListNode head) {
		ListNode pre=null;
		ListNode cur=head;
		ListNode next=head;
		while(cur!=null) {
			next=cur.next;
			cur.next=pre;
			pre=cur;
			cur=next;
		}
		return pre;
    }
}
class ListNode {
      int val;
     ListNode next;
     ListNode(int x) { val = x; }
}
/*
 * 反转一个单链表。
 * 
 * 示例:
 * 
 * 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
 */