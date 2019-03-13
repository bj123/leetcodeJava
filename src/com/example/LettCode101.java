package com.example;
import java.util.LinkedList;
import java.util.Queue;


/**
 *  对称二叉树
 *  
 *  给定一个二叉树，检查它是否是镜像对称的。
 *  
 *  如果同时满足下面的条件，两个树互为镜像：

			它们的两个根结点具有相同的值。
			每个树的右子树都与另一个树的左子树镜像对称。
 * @author qinxuewu
 * 2019年3月12日下午1:52:18
 *
 */
public class LettCode101 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	 public boolean isSymmetric(TreeNode root) {
	        return check(root, root);
	  }
	 
	 /**
	  * 递归实现
	  * @param t1
	  * @param t2
	  * @return
	  */
	 public boolean  check(TreeNode t1,TreeNode t2){
		 if(t1==null && t2==null){
			 return true;
		 }
		 if(t1==null || t2==null){
			 return false;
		 } 
		 return (t1.val==t2.val) && check(t1.right, t2.left) && check(t1.left, t2.right);
	 }
	 
	 
	/**
	 *  迭代实现
	 *  
	 * 每次提取两个结点并比较它们的值。然后，将两个结点的左右子结点按相反的顺序插入队列中。
	 * 当队列为空时，或者我们检测到树不对称（即从队列中取出两个不相等的连续结点）时，该算法结束。
	 */
	 public boolean isSymmetric2(TreeNode root) {
		    Queue<TreeNode> q = new LinkedList<>();
		    q.add(root);
		    q.add(root);
		    while (!q.isEmpty()) {
		        TreeNode t1 = q.poll();
		        TreeNode t2 = q.poll();
		        if (t1 == null && t2 == null) continue;
		        if (t1 == null || t2 == null) return false;
		        if (t1.val != t2.val) return false;
		        q.add(t1.left);
		        q.add(t2.right);
		        q.add(t1.right);
		        q.add(t2.left);
		    }
		    return true;
		}
}
