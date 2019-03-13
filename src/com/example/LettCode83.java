package com.example;



/**
 * 删除排序链表中的重复元素
 * 
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * 
 * @author qinxuewu 2019年3月7日上午9:42:44
 *
 */
public class LettCode83 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(3);
		// while(head!=null){
		// System.out.println(head.val);
		// head=head.next;
		// }
		//

		ListNode root = deleteDuplicates(head);
		while (root != null) {
			System.out.println(root.val);
			root = root.next;
		}
	}

	/**
	 * 遍历方法
	 * @param head
	 * @return
	 */
	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}
		//指向同一个引用
	   ListNode tmp = head;
		while (tmp.next != null) {
			//记录修改结点的下一结点
			if (tmp.val == tmp.next.val) {
				// 如果相等 改变当前节点的next指向
				tmp.next=tmp.next.next;
			}else{
				tmp = tmp.next;

			}
		}
		return head;
	}
	


}
