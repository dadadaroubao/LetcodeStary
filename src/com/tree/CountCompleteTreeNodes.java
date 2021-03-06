package com.tree;

public class CountCompleteTreeNodes {
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
		System.out.println(2 << 4);
		System.out.println(countNodes(node));
		
	}
	
	public static int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		int l = countLeft(root.left);
		int r = countLeft(root.right);
		if (l == r) {// 左子树为满二叉树
			return (1 << l) + countNodes(root.right);
		} else {
			// 如果不相等，就先求出右子树高度在递归遍历左子树
			return (1 << r) + countNodes(root.left);
		}

	}

	private static int countLeft(TreeNode nade) {
		int i = 0;
		while (nade != null) {
			nade = nade.left;
			i++;
		}
		return i;
	}
	
	
}
/*给出一个完全二叉树，求出该树的节点个数。

说明：

完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。

示例:

输入: 
    1
   / \
  2   3
 / \  /
4  5 6

输出: 6  */
