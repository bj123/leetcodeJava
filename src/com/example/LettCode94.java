package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.example.LettCode98.TreeNode;

/**
 * 二叉树的中序遍历
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * @author qinxuewu
 * 2019年3月6日下午5:49:30
 *
 */
public class LettCode94 {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		TreeNode root=new TreeNode(50);
		TreeNode  left1=new TreeNode(30);
		TreeNode  right2=new TreeNode(70);
		root.left=left1;
		root.right=right2;
		
		
		TreeNode  left11=new TreeNode(10);
		TreeNode  right12=new TreeNode(40);
		left1.left=left11;
		left1.right=right12;
		
		
		TreeNode  left21=new TreeNode(60);
		TreeNode  right22=new TreeNode(90);
		right2.left=left21;
		right2.right=right22;
		LettCode94 l=new LettCode94();
		System.out.println(l.inorderTraversal(root).toString());
		
	}
	
	
	/**
	 * 利用栈先进后出   实现中序遍历  
	 * @param root
	 * @return
	 */
	  public  List<Integer> inorderTraversal(TreeNode root) {
	        List<Integer> list = new ArrayList<Integer>();
	        Stack<TreeNode> stack= new Stack<>();
	        while(root != null || !stack.empty()){
	        	//从根节点开始遍历所有左子树 放入栈中
	             while (root != null){
	                stack.push(root);
	                root = root.left;
	            }
	           
	            if(!stack.empty()){
	            	//利用栈先进后出的特性   最先出的肯定是左子树中最小的值
	            	root = stack.pop();
	            	//放入集合中
	            	list.add(root.val);
	                root = root.right;
	            }
	        }
	        return list;
	    }
	  
	  /**
	   * 递归实现中序遍历
	   * @param root
	   * @return
	   */
	  public  List<Integer> inorderTraversal2(TreeNode root) {
		  List<Integer> list = new ArrayList<Integer>();
		  inOrder(root,list);
		  return list;
	  }
	  
	  public  void  inOrder(TreeNode root,List<Integer> list){
		  if(root!=null){
			  inOrder(root.left, list);
			  list.add(root.val);
			  inOrder(root.right,list);
		  }
	  }
}
