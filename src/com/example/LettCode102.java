package com.example;
import java.util.*;

/**
 * 二叉树的层次遍历
 *
 * 给定一个二叉树，返回其按层次遍历的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 例如:
 *
 * 给定二叉树: [3,9,20,null,null,15,7]
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 * @author qinxuewu
 * @version 1.00
 * @time  14/3/2019 上午 11:03
 * @email 870439570@qq.com
 */

public class LettCode102 {
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


        LettCode102 code = new LettCode102();
        List<List<Integer>> result= code.levelOrder(root);
        System.out.println(Arrays.asList(result));

    }

    /**
     * BFS 广度搜索算法
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
      if(root==null){
          return new ArrayList<>();
      }
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int count=queue.size();
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < count; i++){
                TreeNode node=queue.poll();
                list.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return  result;
    }


    /**
     * DFS 深度优先搜索算法实现
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        Integer level = 1;
        List<List<Integer>> result = new ArrayList<>();
        dfs(result,root,level);
        return  result;
    }

    public void dfs(List<List<Integer>> result,TreeNode root,Integer leve){
        if(root==null) return;
        if(result.size()<leve){
            result.add(new ArrayList<>());
        }
        result.get(leve-1).add(root.val);

        dfs(result,root.left,leve+1);
        dfs(result,root.right,leve+1);
    }
}
