package com.tree;

public class SumOfLeftLeaves {
	public static void main(String[] args) {
		TreeNode node=new TreeNode(4);
		TreeNode node1=new TreeNode(7);
		TreeNode node2=new TreeNode(7);
		TreeNode node3=new TreeNode(6);
		TreeNode node4=new TreeNode(9);
		TreeNode node5=new TreeNode(9);
		TreeNode node6=new TreeNode(6);
		node.right=node1;
		node.left=node2;
		node1.left=node3;
		node1.right=node4;
		node2.left=node5;
		node2.right=node6;
		System.out.println(sumOfLeftLeaves(node));
		
	}

	static int sum = 0;

	public static int sumOfLeftLeaves(TreeNode root) {
		return sumOfLeftLeaves(root, false);
	}

	private static int sumOfLeftLeaves(TreeNode root, boolean b) {
		if (root == null)
			return 0;
		if (b && root.left == null && root.right == null)
			sum += root.val;
		else
			sumOfLeftLeaves(root.left, true);
		sumOfLeftLeaves(root.right, false);
		return sum;
	}

	
	
	
}
/*计算给定二叉树的所有左叶子之和。

示例：

    3
   / \
  9  20
    /  \
   15   7

在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
*/
