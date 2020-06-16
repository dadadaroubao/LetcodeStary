package com.queueANDstack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeZigzagLevelOrderTraversal {
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
		List<List<Integer>> list = zigzagLevelOrder(node);
		System.out.println(list.toString());
	}

	 
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new LinkedList<>();

		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int m = 1;
		while (!queue.isEmpty()) {
			List<Integer> tmp = new ArrayList<>();
			int len = queue.size();

			for (int i = 0; i < len; i++) {
				TreeNode node = queue.poll();
				if (m == 1) {
					tmp.add(node.val);

				} else if (m == -1) {
					tmp.add(0, node.val);

				}

				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			m *= -1;
			res.add(tmp);
		}
		return res;
	}
	
}

/*给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

例如：
给定二叉树 [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回锯齿形层次遍历如下：

[
  [3],
  [20,9],
  [15,7]
]

*/
