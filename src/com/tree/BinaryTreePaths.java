package com.tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	
	public static void main(String[] args) {
		TreeNode node=new TreeNode(4);
		TreeNode node1=new TreeNode(7);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(6);
		
		node.right=node1;
		node.left=node2;
		node2.right=node3;
		
		System.out.println(binaryTreePaths(node).toString());
	}

	
	 public static List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<String>();
		if (root == null)
			return null;
		if (root.left == null && root.right == null) {
			res.add(String.valueOf(root.val));
			return res;
		}
		List<String> left = binaryTreePaths(root.left);
		for(int i=0;left!=null && i<left.size();i++) 
			res.add(String.valueOf(root.val) + "->" + left.get(i));
		
		List<String> right = binaryTreePaths(root.right);
		for(int i=0;right != null && i<right.size();i++) 
			res.add(String.valueOf(root.val) + "->" + right.get(i));
		
		return res;
	 }
	
}
/*给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。

示例:

输入:

   1
 /   \
2     3
 \
  5

输出: ["1->2->5", "1->3"]

解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3 */
