package com.example;

import com.example.juc.T;

import java.util.*;

/**
 * . 二叉树的层次遍历 II
 *
 *  给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * @author qinxuewu
 * @version 1.00
 * @time  15/3/2019 上午 9:55
 * @email 870439570@qq.com
 */
public class LettCode107 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left1 = new TreeNode(9);
        TreeNode right1=new TreeNode(20);
        root.left = left1;
        root.right=right1;



        TreeNode left2=new TreeNode(15);
        TreeNode right2 =new TreeNode(7);
        right1.left = left2;
        right1.right = right2;


        LettCode107 code = new LettCode107();
        List<List<Integer>> result= code.levelOrderBottom2(root);
        System.out.println(Arrays.asList(result));

    }

    /**
     * BFS 广度优先搜索
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }


        List<List<Integer>> result=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int count=queue.size();   //记录原来的队列长度，防止添加了子树后队列长度变长
            for (int i =0; i <count ; i++) {
                TreeNode node=queue.poll();
                list.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }

            }
            result.add(0,list);   //从底往上遍历，就把list插入头部；从上往下遍历，就把list插入尾部
        }
        return  result;
    }


    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        LinkedList<List<Integer>> result=new LinkedList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> list=new ArrayList<>();
            int count=queue.size();   //记录原来的队列长度，防止添加了子树后队列长度变长
            for (int i =count; i>0 ; i--) {
                TreeNode node=queue.poll();
                list.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }

            }
            result.push(list);  // push表示入栈，在头部添加元素
        }
        return  result;
    }
}
