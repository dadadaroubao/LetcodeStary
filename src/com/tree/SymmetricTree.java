package com.tree;

public class SymmetricTree {
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
		System.out.println(isSymmetric(node));
		
	}
	
	public static boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}

	private static boolean isSymmetric(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val != q.val)
			return false;
		return isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
	}

}
/*给定一个二叉树，检查它是否是镜像对称的。

 

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:

    1
   / \
  2   2
   \   \
   3    3


*/

