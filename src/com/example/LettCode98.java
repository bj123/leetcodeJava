package com.example;
import java.util.ArrayList;
import java.util.List;



/**
 * 验证二叉搜索树 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 
 * 假设一个二叉搜索树具有如下特征：
 *  节点的左子树只包含小于当前节点的数。 
 *  节点的右子树只包含大于当前节点的数。 
 *  所有左子树和右子树自身必须也是二叉搜索树。
 * 
 * @author qinxuewu 2019年3月6日下午4:53:15
 *
 */
public class LettCode98 {
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
		LettCode98 l=new LettCode98();
		System.out.println(l.isValidBST2(root));
		
	}
	
	/**
	 * 两种解法：
	 * 		利用它本身的性质来做，即左<根<右
	 * 		通过利用中序遍历结果为有序数列来做   从根结点开始(注意并不是先访问根结点),中序遍历根结点的左子树,然后是访问根结点,最后中序遍历右子树
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {	
		  if (root == null) return true;
	      return valid(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}
	
    public boolean valid(TreeNode root, long low, long high) {
        if (root == null) return true;
        if (root.val <= low || root.val >= high) return false;
        return valid(root.left, low, root.val) && valid(root.right, root.val, high);
    }
    
    
    /**
     * 中序遍历解法   通过中序遍历将所有的节点值存到一个数组里，然后再来判断这个数组是不是有序的
     * @param root
     * @return
     */
	public boolean isValidBST2(TreeNode root){	
		   List<Integer> list = new ArrayList<Integer>();
		   inOrder(root, list);
		   System.out.println(list.toString());
	       for (int i = 0; i < list.size() - 1; ++i) {
	            if (list.get(i) >= list.get(i + 1))
	            	return false;
	        }
	        return true;
	}
    //中序遍历
    public void inOrder(TreeNode root,List<Integer> list) {
        if(root != null) {
            inOrder(root.left,list);
            list.add(root.val);
            inOrder(root.right,list);
        }else{
        	return;
        }
    }
}
