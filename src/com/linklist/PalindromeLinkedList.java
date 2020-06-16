package com.linklist;

public class PalindromeLinkedList {
	public static void main(String[] args) {
		int[] a= {1,2,3,2,1};
		ListNode head=createList(a);	
		printList(head);
		boolean b = isPalindrome(head);
		System.out.println(b);
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
	

	public static boolean isPalindrome(ListNode head) {
		if(head == null || head.next == null) {
            return true;
        }
		ListNode fast = head;
		ListNode slow = head;
		ListNode pre = head;//定义一个反向的列表
		ListNode reverse = null;
		while (fast != null && fast.next != null) {
			pre = slow;
			slow = slow.next;
			fast = fast.next.next;
			pre.next=reverse;
			reverse=pre;
		}
		if(fast!=null) {
			slow=slow.next;
		}
		while(slow!=null && reverse!=null) {
			if(slow.val!=reverse.val)
				return false;
			reverse=reverse.next;
			slow=slow.next;
		}
		return true;
	}

}
/*请判断一个链表是否为回文链表。

示例 1:

输入: 1->2
输出: false
示例 2:

输入: 1->2->2->1
输出: true
*/
