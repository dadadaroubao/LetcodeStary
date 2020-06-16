package com.tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInABst {
	public static void main(String[] args) {
		int[] a= {1,2,3,4,5,6};
		TreeNode node = ConvertSortedArrayToBinarySearchTree.sortedArrayToBST(a);
		System.out.println(kthSmallest(node,3));
	}
	
	static int num=0;
	static List<Integer> list=new ArrayList<>();
	public static int kthSmallest(TreeNode root, int k) {
		if(k == 0)
			return root.val;
		num=k;
		list=inOrderRe(root);
		return list.get(k-1);
    }

	private static List<Integer> inOrderRe(TreeNode root) {
		if(num==0)
			return list;
		if(root != null){
            inOrderRe(root.left);
            list.add(root.val);
            num--;
            inOrderRe(root.right);
        }
		return list;		
	}
	
}
/*给定一个二叉搜索树，编写一个函数 kthSmallest 来查找其中第 k 个最小的元素。

说明：
你可以假设 k 总是有效的，1 ≤ k ≤ 二叉搜索树元素个数。

示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 1
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 3
*/
