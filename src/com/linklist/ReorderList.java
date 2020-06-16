package com.linklist;

public class ReorderList {
	public static void main(String[] args) {
		int[] a= {};
		ListNode head=createList(a);	
		printList(head);
	    reorderList(head);
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
	

	public static void reorderList(ListNode head) {
		if(head==null || head.next==null) {
			return ;
		}
		ListNode fast = head;
		ListNode slow = head;
		ListNode pre = head;
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		 pre.next = null;
		//System.out.println(slow.val);
		//将第二段链表翻转,翻转之后头节点为 preNode
        ListNode preNode = null;
        ListNode curNode = slow;
        ListNode nextNode = null;
        while(curNode != null){
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        //将两段链表合并为一段
        ListNode header = new ListNode(0);
        ListNode list = header;
        while(head != null && preNode != null){
            list.next = head;
            head = head.next;
            
            list.next.next = preNode;
            preNode = preNode.next;

            list = list.next.next;
        }
       
        head = header.next;

    }

}
/*给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1:

给定链表 1->2->3->4, 重新排列为 1->4->2->3.
示例 2:

给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
*/
