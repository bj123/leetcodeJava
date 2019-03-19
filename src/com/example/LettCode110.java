package com.example;
/**
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * @author qinxuewu
 * @version 1.00
 * @time  19/3/2019 上午 10:13
 * @email 870439570@qq.com
 */
public class LettCode110 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 思路： 递归求解二叉树的深度,递归条件中加一个判断左右二叉树的高度差是否超过1即可
     *
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        int depth = dfs(root);
        if (depth == -1) {
            return false;
        }
        return true;
    }

    public int  dfs(TreeNode root){
        if(root==null){
            return  0;
        }
        //求出左右树的深度
        int leftDepth=dfs(root.left);
        int rightDepth=dfs(root.right);
        if (leftDepth == -1 || rightDepth == -1){
            return -1;
        }
        //一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
        if (leftDepth - rightDepth > 1 || rightDepth - leftDepth > 1) {
            return -1;
        }
        //分别求出左子树的深度、右子树的深度，两个深度的较大值+1即可。
        return 1 + Math.max(leftDepth, rightDepth);
//        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;

    }
}
