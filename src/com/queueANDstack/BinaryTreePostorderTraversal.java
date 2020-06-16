package com.queueANDstack;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	public static void main(String[] args) {
		TreeNode node=new TreeNode(3);
		TreeNode node1=new TreeNode(2);
		TreeNode node2=new TreeNode(1);
		node2.right=node1;
		node1.left=node;
		List<Integer> list = postorderTraversal(node2);
		System.out.println(list.toString());
	}

	 
	public static List<Integer> postorderTraversal(TreeNode root) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		if (root == null)
			return list;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.add(root);
		while (!stack.empty()) {
			TreeNode node = stack.pop();
			list.addFirst(node.val);
			if (node.left != null) {
				stack.push(node.left);
			}
			if (node.right != null) {
				stack.push(node.right);
			}

		}
		return list;
	}
}

/*给定一个二叉树，返回它的 后序 遍历。

示例:

输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [3,2,1]
*/
