package com.linklist;

public class OddEvenLinkedList {
	public static void main(String[] args) {
		int[] a= {1,2,3,4,5};
		ListNode head=createList(a);	
		printList(head);
		ListNode node = oddEvenList(head);
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
	

	public static ListNode oddEvenList(ListNode head) {
		if(head==null) {
			return head;
		}
		ListNode node=head.next;
		ListNode odd=head;
		ListNode even=head.next;
		while(node!=null && odd.next!=null && even.next!=null ) {
			odd.next=odd.next.next;
			even.next=even.next.next;
			odd=odd.next;
			even=even.next;		
		}
		odd.next=node;
		return head;
	}

}
/*给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

示例 1:

输入: 1->2->3->4->5->NULL
输出: 1->3->5->2->4->NULL */
