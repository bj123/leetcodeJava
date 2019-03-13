package com.example;



/**
 * 相同的树
 * 
 * @author qinxuewu 2019年3月11日上午10:52:46
 * 
 *         给定两个二叉树，编写一个函数来检验它们是否相同。
 * 
 *         如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 */
public class LettCode100 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode left1 = new TreeNode(2);
		// TreeNode right1=new TreeNode(3);
		root.left = left1;
		// root.right=right1;

		TreeNode root2 = new TreeNode(1);
		// TreeNode left2=new TreeNode(2);
		TreeNode right2 = new TreeNode(2);
		root2.left = null;
		root2.right = right2;
		LettCode100 code = new LettCode100();
		System.out.println(code.isSameTree(root, root2));

	}

	/**
	 * 思路：递归遍历判断
	 * 
	 * @param p
	 * @param q
	 * @return
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p != null && q != null && p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} else {
			return false;
		}
	}

}
