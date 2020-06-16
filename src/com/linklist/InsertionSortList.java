package com.linklist;

public class InsertionSortList {

	public static void main(String[] args) {
		int[] a= {4,2,1,3};
		ListNode head=createList(a);	
		printList(head);
		ListNode node = insertionSortList(head);
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
	
	public static ListNode insertionSortList(ListNode head) {
		ListNode dummy=new ListNode(Integer.MIN_VALUE);
		ListNode pro=dummy;
		ListNode tail=dummy;//已排序列最大的值
		ListNode cur=head;
		while(cur!=null) {
			if(cur.val > tail.val) {
				tail.next=cur;
				tail=cur;
				cur=cur.next;
			}else {
				ListNode next=cur.next;
				tail.next=next;
				while(pro.next!=null && pro.next.val<cur.val)
					pro=pro.next;
				cur.next=pro.next;
				pro.next=cur;
				pro=dummy;
				cur=next;
				
			}
		}
		
		return dummy.next;
    }
	
}
/*插入排序算法：

插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
重复直到所有输入数据插入完为止。
 

示例 1：

输入: 4->2->1->3
输出: 1->2->3->4
示例 2：

输入: -1->5->3->4->0
输出: -1->0->3->4->5
*/
