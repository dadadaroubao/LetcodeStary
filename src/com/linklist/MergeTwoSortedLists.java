package com.linklist;

public class MergeTwoSortedLists {
	public static void main(String[] args) {
		int[] a= {1,2,4};
		int[] b= {1,3,4};
	
		ListNode head1=createList(a);
		ListNode head2=createList(b);
		printList(head1);
		printList(head2);
		ListNode node = mergeTwoLists(head1,head2);
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
	

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head=new ListNode(0);
		ListNode node1=l1;
		ListNode node2=l2;
		ListNode node=head;
		while (node1 != null && node2 != null) {
			if (node1.val >= node2.val) {
				node.next = node2;
				node2=node2.next;
			} else {
				node.next = node1;
				node1=node1.next;
			}
			node=node.next;
		}
		if(node1 !=null) {
			node.next=node1;
		}else if(node2!=null) {
			node.next=node2;
		}
		
		return head.next;
    }

}
/*将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

示例：

输入：1->2->4, 1->3->4
输出：1->1->2->3->4->4

*/
