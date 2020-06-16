package com.linklist;

public class ReverseNodedsInK_Group {
	public static void main(String[] args) {
		int[] a= {1,2,3,4,5};
		ListNode head=createList(a);	
		printList(head);
		ListNode node = reverseKGroup(head,3);
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
	
	
	public static ListNode reverseKGroup(ListNode head, int k) {
		if (head == null || head.next == null) {
            return head;
        }
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            //剩余数量小于k的话，则不需要反转。
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        System.out.println(tail.val);
        // 反转前 k 个元素
        ListNode newHead = reverse(head, tail);
        printList(newHead);
        //下一轮的开始的地方就是tail
        head.next = reverseKGroup(tail, k);

        return newHead;
    }

  
    private static ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null;
        ListNode next = null;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;

    }

}
/*给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

k 是一个正整数，它的值小于或等于链表的长度。

如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

 

示例：

给你这个链表：1->2->3->4->5

当 k = 2 时，应当返回: 2->1->4->3->5

当 k = 3 时，应当返回: 3->2->1->4->5


 */
