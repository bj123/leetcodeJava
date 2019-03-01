package com.example;

/**
 * 反转链表
 * 
 * 输入: 1->2->3->4->5->NULL 输出: 5->4->3->2->1->NULL
 * 
 * @author qinxuewu 2019年2月28日上午10:14:26
 *
 */
public class LettCode206 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		ListNode root=new ListNode(1);
		root.next=new ListNode(2);
		root.next.next=new ListNode(3);
		root.next.next.next=new ListNode(4);
		root.next.next.next.next=new ListNode(5);
		root.next.next.next.next.next=null;
//		while(root!=null){
//			System.out.println(root.val);
//			root=root.next;
//		}
		
//		ListNode reverseList=reverseList(root);
//		while(reverseList!=null){
//			System.out.println(reverseList.val);
//			reverseList=reverseList.next;
//		}
		
		ListNode reverseList=reverseList3(root);
		while(reverseList!=null){
			System.out.println(reverseList.val);
			reverseList=reverseList.next;
		}
	}

	/**
	 * 思路：把next指针指向他的前驱.
	 *  为了避免“断链”，我们必须在指针更改指向之前，保存修改结点的下一结点 同时我们也必须存储上一个结点，因为next域即将修改指向该结点
	 * @param head
	 * @return
	 */
	public static  ListNode reverseList(ListNode head) {
		ListNode pre = null;

        while(head != null) {
        	//记录修改结点的下一结点
        	 ListNode tmp  = head.next;
            // 进行变换 next指向前置
        	 head.next = pre;
            //保存前置节点为当前节点 
            pre = head;
             //最后当前节点赋值为未修改前的下一节点 。接着循环方便跳过已经更改的节点
            head = tmp ;
        }
        return pre;
	}
	

	
	/**
	 * 递归实现
	 * @param pHead
	 * @return
	 */
	public  static  ListNode reverseList3(ListNode head){
		if(head==null || head.next == null){
			//如果没有结点或者只有一个结点直接返回pHead
			return head;
		}
		ListNode next = head.next; //保存当前结点的下一结点
		head.next = null;  
		//递归结束时reverseHead一定是新链表的头结点
		ListNode reverseHead = reverseList3(next); 
		next.next = head; //修改指针域
		return reverseHead;
	}

}
