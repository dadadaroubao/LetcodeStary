package com.queueANDstack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeLevelOrderTraversal {
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
		List<List<Integer>> list = levelOrder(node);
		System.out.println(list.toString());
	}

	 
	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res=new ArrayList<>();
		
		if(root==null)
			return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			List<Integer> tmp = new ArrayList<>();
			int len=queue.size();
			for (int i = 0; i < len; i++) {
				TreeNode node = queue.poll();
				tmp.add(node.val);
				if(node.left!=null)
					queue.add(node.left);
				if(node.right!=null)
					queue.add(node.right);
			}
			res.add(tmp);
		}
		return res;
    }
}

/*给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。

 

示例：
二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回其层次遍历结果：

[
  [3],
  [9,20],
  [15,7]
]
*/
