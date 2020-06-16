package com.linklist;

public class RemoveDuplicatesFromSortedListⅡ {
	public static void main(String[] args) {
		int[] a= {1,2,3,3,3,4,4,5};
		ListNode head=createList(a);	
		printList(head);
		ListNode node = deleteDuplicates(head);
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
	

	 public static ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		while(cur.next!=null && cur.next.next!=null) {
			if(cur.next.val==cur.next.next.val) {
				ListNode node=cur.next;
				while(node!=null && node.next!=null && node.val==node.next.val) {
					node=node.next;
				}
				cur.next=node.next;
			}else {
				cur=cur.next;
			}
		}
		ListNode resNode=dummy.next;
		dummy=null;
		return resNode;
	 }

}
/*给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:

输入: 1->2->3->3->4->4->5
输出: 1->2->5

 */
