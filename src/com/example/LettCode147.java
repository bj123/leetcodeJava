package com.example;

/**
 * 147. 对链表进行插入排序
 *
 *
 * @author qxw
 * @version 1.00
 * @time  14/5/2019 上午 10:15
 */
public class LettCode147 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 插入排序算法：
     *
     *   将原链表分为两个部分：已排好序和未排好序，pre指针代表已排好序链表的哑节点，
     *   cur为未排序链表的头节点。进行插入操作时，cur指针依次遍历原链表，
     *   pre指针遍历黑色表示的元素，找到正确的插入位置，将cur节点插入，然后cur指针指向下一个待排序的元素
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        if(head==null || head.next==null){
            return  head;
        }

        //了方便在头节点之前进行插入，我们在头节点之前插入一个无效的节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next=head;

        //待插入进行排序的节点
        ListNode cur=head;
        // 正确插入位置的指针
        ListNode pre=dummyHead;

        // 下一个插入结点
        ListNode next;

        while (cur!=null){
            next=cur.next;
            // 插入查找
            while (pre.next!=null && pre.next.val < cur.val){
                pre=pre.next;
            }
            // 断开现有结点
            cur.next = pre.next;
            pre.next = cur;
            pre = dummyHead;
            cur = next;
        }

        return dummyHead.next;
    }
}
