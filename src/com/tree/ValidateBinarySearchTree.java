package com.tree;

import java.util.Stack;

public class ValidateBinarySearchTree {
	public static void main(String[] args) {
		TreeNode node=new TreeNode(4);
		TreeNode node1=new TreeNode(7);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(6);
		node.right=node1;
		node.left=node2;
		node1.left=node3;	
		System.out.println(isValidBST(node));		
	}

	static boolean result = true;
	static Stack<Integer>  stack = new Stack<Integer>();

	public static boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		inOrder(root);
		return result;

	}

	private static void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		if(stack.size()>0)
			if(stack.peek()>=root.val)
				result=false;
		stack.add(root.val);
		inOrder(root.right);

	}
	 
}
/*给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
示例 1:

输入:
    2
   / \
  1   3
输出: true
示例 2:

输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。
*/

