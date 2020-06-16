package com.tree;



public class DeleteNodeInABst {
	public static void main(String[] args) {
		TreeNode node=new TreeNode(4);
		TreeNode node1=new TreeNode(7);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(6);
		node.right=node1;
		node.left=node2;
		node1.left=node3;	
		System.out.println(deleteNode(node,2));		
	}

	public static TreeNode deleteNode(TreeNode root, int key) {
		if (root == null)
			return root;
		if (key > root.val)// 要删除值大于root的值，去右子树找
			root.right = deleteNode(root.right, key);
		else if (key < root.val)// 要删除值小于root的值，去左子树找
			root.left = deleteNode(root.left, key);
		else {
			if (root.left == null && root.right == null)// 是叶子节点
				return null;

			else if (root.left == null) {// 当前节点没有左子树
				return root.right;
			}

			else if (root.right == null) { // 当前节点没有右子树
				return root.left;
			} else {// 左右节点都存在
					// 找到右子树最小的节点
				TreeNode node = root.right;
				while (node.left != null)
					node = node.left;
				//将node指向root的左子树
				node.left = root.left;
				return root.right;
			}
		}
		return root;
	}

	
	 
}
/*给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。

一般来说，删除节点可分为两个步骤：

首先找到需要删除的节点；
如果找到了，删除它。
说明： 要求算法时间复杂度为 O(h)，h 为树的高度。

示例:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。

一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。

    5
   / \
  4   6
 /     \
2       7

另一个正确答案是 [5,2,6,null,4,null,7]。

    5
   / \
  2   6
   \   \
    4   7


*/

