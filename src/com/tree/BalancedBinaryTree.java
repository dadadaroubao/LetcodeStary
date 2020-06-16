package com.tree;

public class BalancedBinaryTree {
	public static void main(String[] args) {
		TreeNode node = new TreeNode(4);
		TreeNode node1 = new TreeNode(7);
		TreeNode node2 = new TreeNode(7);
		TreeNode node3 = new TreeNode(6);
		TreeNode node4 = new TreeNode(9);
		TreeNode node5 = new TreeNode(9);
		TreeNode node6 = new TreeNode(6);
		node.right = node1;
		node.left = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		System.out.println(isBalanced(node));
	}
	
	public static boolean isBalanced(TreeNode root) {
        return Heigh(root) != -1;        
    }

	private static int Heigh(TreeNode root) {
		if(root ==null )
			return 0;
		
		int left=Heigh(root.left);
		if(left==-1) {
			return -1;
		}
		
		int right=Heigh(root.right);
		if(right==-1) {
			return -1;
		}
		return Math.abs(left-right)<2? Math.max(right,left)+1 :-1;
	}


}
/*给定一个二叉树，判断它是否是高度平衡的二叉树。

本题中，一棵高度平衡二叉树定义为：

一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

示例 1:

给定二叉树 [3,9,20,null,null,15,7]

    3
   / \
  9  20
    /  \
   15   7
返回 true 。

示例 2:

给定二叉树 [1,2,2,3,3,null,null,4,4]

       1
      / \
     2   2
    / \
   3   3
  / \
 4   4
返回 false 。*/

