package com.queueANDstack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BinaryTreeRightSideView {
	public static void main(String[] args) {
		TreeNode node=new TreeNode(1);
		TreeNode node1=new TreeNode(2);
		TreeNode node2=new TreeNode(3);
		TreeNode node3=new TreeNode(4);
		TreeNode node4=new TreeNode(5);
		
		node.right=node2;
		node.left=node1;
		node1.right=node4;
		node2.right=node3;
		List<Integer> list = rightSideView(node);
		System.out.println(list.toString());
	}

	 
	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new LinkedList<>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			List<Integer> tmp = new ArrayList<>();
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				TreeNode node = queue.poll();
				tmp.add(node.val);
				
				if (node.right != null) {
					queue.add(node.right);				
				}
				if (node.left != null) {
					queue.add(node.left);
				}
			}
			System.out.println(tmp.toString());
			res.add(tmp.get(0));
		}
		return res;
    }
	
}

/*给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例:

输入: [1,2,3,null,5,null,4]
输出: [1, 3, 4]
解释:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---



*/
