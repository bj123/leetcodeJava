package com.example;


/**
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 *
 * @author qinxuewu
 * @version 1.00
 * @time  20/3/2019 上午 10:01
 * @email 870439570@qq.com
 */
public class LettCode112 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     *   思路：就是一个沿着各个路径查找的过程，每次经过一个节点，sum就减去当前节点的val值。
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        //当root为叶子节点时（左节点与右节点都是null，且传入的sum值刚好等于这个叶子节点的值，即返回true）
        if (root.left == null && root.right == null && sum == root.val) {
            return true;
        }
        //分别探索root节点的左节点+右节点
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }


}
