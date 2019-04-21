package com.example;
/**
 * 合并两个有序链表
 * 
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * 
 *  输入：1->2->4, 1->3->4
	输出：1->1->2->3->4->4
	
	
 * @author qinxuewu
 * 2019年2月20日上午10:13:05
 *
 */
public class LettCode21 {
	public static class ListNode{
		//数据域
		int val;
		//指针域 指向下一个节点
		ListNode next;
		
		// 头结点的构造方法
		public ListNode(ListNode nextval) {
			this.next = nextval;
		}

		ListNode(int x) { 
			val = x; 
		}
		
	}
	
	 public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 if (l1 == null) return l2;
	     if (l2 == null) return l1;
	        
		 ListNode head =new ListNode(null);
		 ListNode cur = head ;
		 while(l1!=null && l2 !=null){
			 if(l1.val<=l2.val){
				 cur.next=l1;
				 l1=l1.next;
			 }else{
				 cur.next=l2;				
				 l2=l2.next;
			 }
			 cur=cur.next;
		 }
		  //任一为空，直接连接另一条链表
	        if (l1 == null) {
	            cur.next = l2;
	        } else {
	            cur.next = l1;
	        }
		 return head.next;
	  }
	
	 public static void main(String[] args) {
		 ListNode l1=new ListNode(1);
		 ListNode l2=new ListNode(2);
		 ListNode l3=new ListNode(4);
		 l1.next=l2;
		 l2.next=l3;
		 l3.next=null;
		 
		 
		 ListNode l4=new ListNode(1);
		 ListNode l5=new ListNode(3);
		 ListNode l6=new ListNode(4);
		 l4.next=l5;
		 l5.next=l6;
		 l6.next=null;
		 

		 ListNode list=mergeTwoLists(l1, l4);
		 while(list!=null){
			 System.out.println(list.val);
			 list=list.next;
		 }
	}
}
