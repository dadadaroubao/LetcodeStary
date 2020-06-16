package com.linklist;

public class AddTwoNumbersⅡ {
	public static void main(String[] args) {
		int[] a= {7,2,4,3};
		int[] b= {5,6,4};
	
		ListNode head1=createList(a);
		ListNode head2=createList(b);
		printList(head1);
		printList(head2);
		ListNode node = addTwoNumbers(head1,head2);
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
	

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		l1=reverseList(l1);
		l2=reverseList(l2);
		ListNode pre = new ListNode(0);
		ListNode cur = pre;
		int remainder = 0;
		while (l1 != null || l2 != null) {
			int x = l1 == null ? 0 : l1.val;
			int y = l2 == null ? 0 : l2.val;
			int sum = x + y + remainder;

			remainder = sum / 10;
			sum = sum % 10;
			cur.next = new ListNode(sum);

			cur = cur.next;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if (remainder != 0) {
			cur.next = new ListNode(remainder);
		}
		return reverseList(pre.next);
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
/*给定两个非空链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储单个数字。将这两数相加会返回一个新的链表。

 

你可以假设除了数字 0 之外，这两个数字都不会以零开头。

进阶:

如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。

示例:

输入: 
(7 -> 2 -> 4 -> 3) + 
     (5 -> 6 -> 4)
输出: 
7 -> 8 -> 0 -> 7


*/
