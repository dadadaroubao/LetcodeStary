package com.tree;

public class SameTree {
	public static void main(String[] args) {
		TreeNode node=new TreeNode(4);
		TreeNode node1=new TreeNode(7);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(6);
		TreeNode node4=new TreeNode(9);
		TreeNode node5=new TreeNode(1);
		TreeNode node6=new TreeNode(3);
		node.right=node1;
		node.left=node2;
		node1.left=node3;
		node1.right=node4;
		node2.left=node5;
		node2.right=node6;
		System.out.println(isSameTree(node,node));
		
	}
	
	 public static boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val != q.val)
			return false;
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	 }

}
/*给定两个二叉树，编写一个函数来检验它们是否相同。

如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

示例 1:

输入:       1         1
          / \       / \
         2   3     2   3

        [1,2,3],   [1,2,3]

输出: true
示例 2:

输入:      1          1
          /           \
         2             2

        [1,2],     [1,null,2]

输出: false


*/

