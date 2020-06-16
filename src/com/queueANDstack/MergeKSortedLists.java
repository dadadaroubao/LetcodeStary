package com.queueANDstack;

import java.util.Comparator;
import java.util.PriorityQueue;



public class MergeKSortedLists {
	public static void main(String[] args) {
		int[] num1= {1,4,5};
		int[] num2= {1,3,4};
		int[] num3= {2,6};
		ListNode node1 = createList(num1);
		ListNode node2 = createList(num2);
		ListNode node3 = createList(num3);
		ListNode[] a= {node1,node2,node3};
		ListNode mergeKLists = mergeKLists(a);
		printList(mergeKLists);
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
	
	public static ListNode mergeKLists(ListNode[] lists) {
		 int len = lists.length;
	        if (lists == null || len == 0) {
	            return null;
	        }
	        // 使用优先队列对链表进行排序
		PriorityQueue<ListNode> pq = new PriorityQueue<>(new nodeComparator()) ;
		for(int i=0;i<len;i++) {
			while(lists[i]!=null) {
				pq.add(lists[i]);
				lists[i]=lists[i].next;
			}
		}
		ListNode dummy=new ListNode(0);
		ListNode node=dummy;
		while(!pq.isEmpty()) {
			ListNode poll = pq.poll();
			poll.next=null;
			node.next=poll;
			node=node.next;
		}
		

		return dummy.next;	
    }

}
class nodeComparator implements Comparator<ListNode>{
    @Override
    public int compare(ListNode n1,ListNode n2){
        return n1.val - n2.val ;   
    }      
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}



/*合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
输入:
[
  1->4->5,
  1->3->4,
  2->6
]
输出: 1->1->2->3->4->4->5->6
*/
