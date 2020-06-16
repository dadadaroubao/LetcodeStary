package com.tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumⅡ {
	
	public static void main(String[] args) {
		TreeNode node=new TreeNode(4);
		TreeNode node1=new TreeNode(7);
		TreeNode node2=new TreeNode(2);
		TreeNode node3=new TreeNode(6);
		
		node.right=node1;
		node.left=node2;
		node2.right=node3;
		
		System.out.println(pathSum(node,12).toString());
		
	}
	
	static List<List<Integer>> res;

	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		backTrack(root, sum, 0, new ArrayList<Integer>());
		return res;
	}

	private static void backTrack(TreeNode root, int sum, int cur, ArrayList<Integer> list) {// 该条路径和sum是否相等
		list.add(root.val);
		cur += root.val;
		if (root.right == null && root.left == null) {
			if (sum == cur)
				res.add(new ArrayList<>(list));
			list.remove(list.size() - 1);
			return;
		}
		if (root.left != null)
			backTrack(root.left, sum, cur, list);
		if (root.right != null)
			backTrack(root.right, sum, cur, list);
		list.remove(list.size() - 1);

	}

}
/*给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。

说明: 叶子节点是指没有子节点的节点。

示例:
给定如下二叉树，以及目标和 sum = 22，

              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
返回:

[
   [5,4,11,2],
   [5,8,4,5]
]
*/
