package com.tree;

public class MinimumepthOfBinaryree {
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
		System.out.println(minDepth(node));
	}

	public static int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		// 1.左孩子和有孩子都为空的情况，说明到达了叶子节点，直接返回1即可
		if (root.left == null && root.right == null)
			return 1;

		
		int left = minDepth(root.left);
		int right = minDepth(root.right);
		// 2.如果左孩子和由孩子其中一个为空，那么需要返回比较大的那个孩子的深度
		if (root.left == null || root.right == null)
			return Math.max(left, right) + 1;
		// 3.最后一种情况，也就是左右孩子都不为空，返回最小深度+1即可
		return Math.min(left, right) + 1;
	}
}


/*给定一个二叉树，找出其最小深度。

最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

说明: 叶子节点是指没有子节点的节点。

示例:

给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回它的最小深度  2.
 */


