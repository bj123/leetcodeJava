package com.example;
import java.util.HashSet;
import java.util.Set;

/**
 * 环形链表
 * 
 * 给定一个链表，判断链表中是否有环。
 * 
 * 两种解决方案： 哈希表 双指针（快慢指针）
 * 
 * @author qinxuewu 2019年3月1日上午10:26:08
 *
 */
public class LettCode141 {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	/***
	 * 哈希表解决 遍历链表存储每个结点的引用（或内存地址)存储在HashSet中 每次判断是否set中存在 如果存在说明是环形链表
	 * 时间复杂度是On加set集合的一次判断O(1)
	 * 
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
		boolean falg = false;
		Set<ListNode> set = new HashSet<>();
		while (head != null) {
			if (set.contains(head)) {
				falg = true;
				return falg;
			}
			set.add(head);
			head = head.next;
		}
		return falg;
	}

	/**
	 * 双指针法（快慢指针）： 利用一个快指针和一个慢指针 
	 * 慢指针每次移动一步，而快指针每次移动两步。
	 * 如果列表中不存在环，最终快指针将会最先到达尾部，此时我们可以返回 false。 
	 * 
	 * @param head
	 * @return
	 */
	public boolean hasCycle2(ListNode head) {

		if (head == null || head.next == null) {
			return false;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}
}
