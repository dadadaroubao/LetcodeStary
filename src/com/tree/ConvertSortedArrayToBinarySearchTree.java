package com.tree;

public class ConvertSortedArrayToBinarySearchTree {
	public static void main(String[] args) {
		int[] a= {-10,-3,0,5,9};
		sortedArrayToBST(a);
	}
	
	public static TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length==0)
			return null;
		return create(nums,0,nums.length-1);
    }

	private static TreeNode create(int[] nums, int l, int r) {
		if (l > r)
			return null;
		if (l == r)
			return new TreeNode(nums[l]);
		int mid = (r - l) / 2 + l;// 中位数的索引
		TreeNode node = new TreeNode(nums[mid]);
		node.left = create(nums, l, mid - 1);
		node.right = create(nums, mid + 1, r);
		return node;
	}

}
/*将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。

示例:

给定有序数组: [-10,-3,0,5,9],

一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
*/
