package com.linklist;

public class RemoveLinkedListElements {

	public static void main(String[] args) {
		int[] a= {1,2,6,3,4,5,6};
		ListNode head=createList(a);	
		printList(head);
		ListNode node = removeElements2(head,6);
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
	
	public static ListNode removeElements(ListNode head, int val) {
		if(head==null) 
			return head;
		
		ListNode dummmyHead=new ListNode(0);
		dummmyHead.next=head;	
		ListNode cur=dummmyHead;
		while(cur.next!=null) {
			if(cur.next.val==val) {
				ListNode delNode=cur.next;
				cur.next=delNode.next;
				delNode=null;
			}else {
				cur=cur.next;
			}
		}
		ListNode resNode=dummmyHead.next;
		dummmyHead=null;
		return resNode;
    }
	
	public static ListNode removeElements2(ListNode head, int val) {
		
		while(head!=null && head.val==val) {
			ListNode delNode=head;
			head=delNode.next;
			delNode=null;
		}
		
		if(head==null) 
			return head;
		
		ListNode cur=head;
		while(cur.next!=null) {
			if(cur.next.val==val) {
				ListNode delNode=cur.next;
				cur.next=delNode.next;
				delNode=null;
			}else {
				cur=cur.next;
			}
		}
		return head;
    }
}
/*
 * 删除链表中等于给定值 val 的所有节点。
 * 示例:
 * 
 * 输入: 1->2->6->3->4->5->6, val = 6 输出: 1->2->3->4->5
 */