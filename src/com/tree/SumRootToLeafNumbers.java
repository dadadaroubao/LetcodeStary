package com.tree;


public class SumRootToLeafNumbers {
	
	public static void main(String[] args) {
		TreeNode node=new TreeNode(4);
		TreeNode node1=new TreeNode(7);
		TreeNode node2=new TreeNode(2);	
		node.right=node1;
		node.left=node2;
		System.out.println(sumNumbers(node));
		
	}
	
	 public static int sumNumbers(TreeNode root) {
		 if(root == null)
			 return 0;
		 return sumNumbers(root,0);    
	 }

	private static int sumNumbers(TreeNode root, int sum) {
		if(root==null) 
			return 0;
		sum=root.val+sum*10;
		if(root.right==null && root.left==null)
			return sum;
		return sumNumbers(root.right,sum)+sumNumbers(root.left,sum);
	}

}
/*给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。

例如，从根到叶子节点路径 1->2->3 代表数字 123。

计算从根到叶子节点生成的所有数字之和。

说明: 叶子节点是指没有子节点的节点。

示例 1:

输入: [1,2,3]
    1
   / \
  2   3
输出: 25
解释:
从根到叶子节点路径 1->2 代表数字 12.
从根到叶子节点路径 1->3 代表数字 13.
因此，数字总和 = 12 + 13 = 25.

*/
