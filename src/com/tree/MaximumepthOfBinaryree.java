package com.tree;

public class MaximumepthOfBinaryree {
	public static void main(String[] args) {
		TreeNode node=new TreeNode(3);
		TreeNode node1=new TreeNode(20);
		TreeNode node2=new TreeNode(9);
		TreeNode node3=new TreeNode(15);
		TreeNode node4=new TreeNode(7);
		node.right=node1;
		node.left=node2;
		node1.left=node3;
		node1.right=node4;
		System.out.println(maxDepth(node));
	}

	public static int maxDepth(TreeNode root) {
		if(root==null)
			return 0;
		int left=maxDepth(root.left);
		int right=maxDepth(root.right);
		
		return Math.max(left, right)+1;
    }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
/*给定一个二叉树，找出其最大深度。

二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

说明: 叶子节点是指没有子节点的节点。

示例：
给定二叉树 [3,9,20,null,null,15,7]，

    3
   / \
  9  20
    /  \
   15   7  */


