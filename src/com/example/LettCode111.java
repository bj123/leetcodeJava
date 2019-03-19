package com.example;
/**
 * 求二叉树的最小深度
 * @author qinxuewu
 * @version 1.00
 * @time  19/3/2019 上午 10:33
 * @email 870439570@qq.com
 */
public class LettCode111 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        //树为空返回0
        if(root==null){
            return  0;
        }
        //如果左子树为空，则返回右子树的最下深度加1
        if(root.left==null){
                return  minDepth(root.right)+1;
        }
        //如果右子树为空， 返回坐子树的最小深度加+1；
        if(root.right==null){
            return  minDepth(root.left)+1;
        }
        // 都为空，则返回左右子树中最小深度+1
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        return  Math.min(leftDepth,rightDepth)+1;
    }
}
