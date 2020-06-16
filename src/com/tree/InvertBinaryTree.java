package com.tree;

public class InvertBinaryTree {
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
		TreeNode tree = invertTree(node);
		System.out.println(tree.val);
		System.out.print(tree.left.val+" ");
		System.out.println(tree.right.val+" ");
		System.out.print(tree.left.left.val+" ");
		System.out.print(tree.left.right.val+" ");
		System.out.print(tree.right.left.val+" ");
		System.out.println(tree.right.right.val+" ");
	}
	
	public static TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		invertTree(root.left);
		invertTree(root.right);
		TreeNode tmp = root.left;
		root.left = root.right;
		root.right = tmp;
		return root;
	}

}
/*翻转一棵二叉树。

示例：

输入：

     4
   /   \
  2     7
 / \   / \
1   3 6   9
输出：

     4
   /   \
  7     2
 / \   / \
9   6 3   1
*/

