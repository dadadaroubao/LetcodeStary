package com.dp;

public class HouseRobber3 {
	
	public static void main(String[] args) {
		TreeNode node = new TreeNode(4);
		TreeNode node1 = new TreeNode(7);
		TreeNode node2 = new TreeNode(7);
		TreeNode node3 = new TreeNode(6);
		TreeNode node4 = new TreeNode(9);
		TreeNode node5 = new TreeNode(9);
		TreeNode node6 = new TreeNode(6);
		node.right = node1;
		node.left = node2;
		node1.left = node3;
		node1.right = node4;
		node2.left = node5;
		node2.right = node6;
		System.out.println(rob(node));
	}
/*这道升级版的树状动态规划问题也可以由一维的dp延伸来，只是情况稍微复杂一些，每一个节点的dp值与三层二叉树的结点dp值相关。对于下图所示的一棵三层满二叉树来说：

    1
  /   \
 2     3
/ \   / \ 
4   5 6   7

在每个结点的金额非负的情况下，且要保证取值结点不相邻，只可能有四种最大的取值方式：

1. 结点2 + 结点3
2. 结点1 + 结点4 + 结点5 + 结点6 + 结点7
3. 结点2 + 结点6 + 结点7
4. 结点3 + 结点4 + 结点5

dp[root] = Max(dp[l]+dp[r], root.val+dp[ll]+dp[lr]+dp[rr]+dp[rl]);
*/


	public static int rob(TreeNode root) {	
		return Solution(root).val;
    }

	private static TreeNode Solution(TreeNode root) {
		if (root == null)
			return Solution(new TreeNode(0));
		
		if (root.left == null && root.right == null) {
			root.left = new TreeNode(0);
			root.right = new TreeNode(0);
			return root;
		}
		root.left = Solution(root.left);
        root.right = Solution(root.right);
        root.val = Math.max(root.left.val + root.right.val, root.val + root.left.left.val + root.left.right.val + root.right.left.val + root.right.right.val);
		return root;
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
/*
在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
  如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

示例 1:

输入: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

输出: 7 
解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
示例 2:

输入: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

输出: 9
*/
