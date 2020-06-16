package com.tree;

public class LowestCommonAncestorOfABinaryTree {
	

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(root ==null || p==null || q==null)
			return null;
		if(root==p || root == q)
			return root;
		TreeNode left=lowestCommonAncestor(root.left,p,q);
		TreeNode right=lowestCommonAncestor(root.right,p,q);
		if(left != null && right !=null)
			return root;
		else if(left ==null)
			return right;
		return left;
        
    }
	
}
/* 
解题思路
使用递归求解，问题分析
如果 root==p|| root==q 则root一定为最近公共子节点
否则 如果一个节点在root的左子树 一个在root的右子树 则root一定为公共子节点
若均在root的左子树则公共子节点一定也在root的左子树中，此时问题转换为从root的左子树中找 p和q的公共子节点。
若均在root的右子树同在左子树情况相同

递归解题思路：
步骤一：严格定义递归函数 函数名 参数 和返回值
步骤二：先一般情况，再特殊情况
步骤三：有退出条件
步骤四：每次调用来缩小问题规模

作者：mr_wong
链接：https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/solution/236-er-cha-shu-de-zui-jin-gong-gong-zu-xian-by-mr_/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。 
 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]
示例 1:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
示例 2:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。
*/
