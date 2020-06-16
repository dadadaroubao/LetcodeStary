package com.linklist;

public class RemoveNthNodeFromEndOfList {
	public static void main(String[] args) {
		int[] a= {1,2,3,4,5};
		ListNode head=createList(a);	
		printList(head);
		ListNode node = removeNthFromEnd(head,3);
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
	

	public static ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dummy=new ListNode(0);
		dummy.next=head;
		ListNode l=dummy;
		ListNode r=dummy;
		for(int i=0;i<n+1;i++) {
			r=r.next;
		}
		while(r!=null) {
			l=l.next;
			r=r.next;
		}
		ListNode del=l.next;
		l.next=del.next;
		del=null;
		return dummy.next;
    }

}
/*给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

示例：

给定一个链表: 1->2->3->4->5, 和 n = 2.

当删除了倒数第二个节点后，链表变为 1->2->3->5.
*/
