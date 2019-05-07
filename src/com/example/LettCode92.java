package com.example;

/**
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * @author qinxuewu
 * @version 1.00
 * @time  6/5/2019 上午 10:29
 * @email 870439570@qq.com
 */
public class LettCode92 {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 定位到要反转部分的头节点 2，head = 2；前驱结点 1，pre = 1；
     *
     * 当前节点的下一个节点3调整为前驱节点的下一个节点 1->3->2->4->5,
     *
     * 当前结点仍为2， 前驱结点依然是1，重复上一步操作。。。
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        for(int i = 1; i < m; i++){
            pre = pre.next;
        }
        head = pre.next;
        for(int i = m; i < n; i++){
            ListNode nex = head.next;
            head.next = nex.next;
            nex.next = pre.next;
            pre.next = nex;
        }
        return dummy.next;
    }
}
