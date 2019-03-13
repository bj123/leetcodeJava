package com.example;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * @author qinxuewu
 * @version 1.00
 * @time  13/3/2019 下午 12:34
 * @email 870439570@qq.com
 */
public class LettCode104 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    /**
     * 递归
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }

    public int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            ++res;
            for (int i = q.size(); i > 0; --i) {
                TreeNode t = q.poll();
                if (t.left != null) q.offer(t.left);
                if (t.right != null) q.offer(t.right);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        TreeNode root=new TreeNode(3);
        TreeNode left=new TreeNode(9);
        TreeNode right=new TreeNode(20);
        root.left=left;
        root.right=right;

        TreeNode left2=new TreeNode(9);
        TreeNode right2=new TreeNode(20);
        right.left=left2;
        right.right=right2;

        System.out.println(maxDepth(root));

    }
}
