package com.queueANDstack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeLevelOrderTraversalⅡ {
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
		List<List<Integer>> list = levelOrderBottom(node);
		System.out.println(list.toString());
	}

	 
	public static List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();

		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			List<Integer> tmp = new ArrayList<>();
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				TreeNode node = queue.poll();
				tmp.add(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			
			res.add(0,tmp);
		}
		return res;
	}
	
}

/*给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

 

示例：
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [15,7],
  [9,20],
  [3]
]
*/
