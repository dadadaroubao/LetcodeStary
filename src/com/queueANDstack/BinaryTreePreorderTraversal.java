package com.queueANDstack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
	public static void main(String[] args) {
		TreeNode node=new TreeNode(3);
		TreeNode node1=new TreeNode(2);
		TreeNode node2=new TreeNode(1);
		node2.right=node1;
		node1.left=node;
		List<Integer> list = preorderTraversal(node2);
		System.out.println(list.toString());
	}

	 
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list=new ArrayList<Integer>();
		if(root==null)
			return list;
		Stack<TreeNode> stack=new Stack<TreeNode>();
		while(!stack.empty() || root!=null) {
			while(root!=null) {
				list.add(root.val);
                stack.push(root);
                root = root.left;
			}
			root = stack.pop().right;
		}
		return list;  
	}
}
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
/*给定一个二叉树，返回它的 前序 遍历。

 示例:

输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [1,2,3]*/
