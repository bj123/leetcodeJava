package com.example;

import java.util.Stack;

/**
 * 将有序数组转换为二叉搜索树
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 * @author qinxuewu
 * @version 1.00
 * @time  18/3/2019 上午 11:25
 * @email 870439570@qq.com
 */

public class LettCode108 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        int left = 0;
        int right = nums.length - 1;
        //  // 左右等分建立左右子树，中间节点作为子树根节点，递归该过程
        return buildTree(nums, left, right);
    }

    private static TreeNode buildTree(int[] nums,int left,int right) {
        int middle = (left + right)/2;
        if(middle > right || middle < left)
            return null;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = buildTree(nums, left, middle - 1);
        root.right = buildTree(nums, middle + 1, right);
        return root;
    }
}
