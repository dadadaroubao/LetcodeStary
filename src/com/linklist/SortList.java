package com.linklist;

public class SortList {

	public static void main(String[] args) {
		int[] a= {4,2,1,3};
		ListNode head=createList(a);	
		printList(head);
		ListNode node = sortList(head);
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
	
	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode mid = findMiddle(head);
		ListNode right = sortList(mid.next);
		mid.next = null;

		ListNode left = sortList(head);

		return merge(left, right);
	
    }

	private static ListNode merge(ListNode left, ListNode right) {
		ListNode l=left;
		ListNode r=right;
		ListNode dummy=new ListNode(Integer.MIN_VALUE);
		ListNode node=dummy;
		while(l!=null && r!=null) {
			while(l!=null && l.val<=r.val) {
				node.next=new ListNode(l.val);
				l=l.next;
				node=node.next;
			}
			while(r!=null && l!=null && r.val<=l.val) {
				node.next=new ListNode(r.val);
				r=r.next;
				node=node.next;
			}
		}
		
		if(l==null) {
			node.next=r;
		}else if(r==null) {
			node.next=l;
		}
		return dummy.next;
	}

	private static ListNode findMiddle(ListNode head) {
		ListNode fast=head.next;
		ListNode slow=head;
		while(fast!=null && fast.next!=null) {
			fast=fast.next.next;
			slow=slow.next;
		}
		return slow;
	}
	
}
/*在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。

示例 1:

输入: 4->2->1->3
输出: 1->2->3->4
示例 2:

输入: -1->5->3->4->0
输出: -1->0->3->4->5
*/
