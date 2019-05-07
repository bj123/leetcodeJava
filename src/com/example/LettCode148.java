package com.example;

/**
 * 排序链表
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * @author qinxuewu
 * @version 1.00
 * @time  6/5/2019 上午 9:51
 * @email 870439570@qq.com
 */
public class LettCode148 {


    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

    }



    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return  head;
        }
        //平分结点，分成两个分支
        ListNode cur=null,slow=head,fast=head;

        //如果是奇数个结点，多出来的一个结点放在了后面的部分
        while (fast!=null && fast.next!=null){
            cur=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        cur.next=null;

        //每个分支都要排序，然后按序合并
        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);

        //按序合并，子分支和大分支都在这里合并
        return merge(l1, l2);
    }

    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(0), p = res;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                res.val = l1.val;
                //这一句别忘了
                p.next = l1;
                l1 = l1.next;
            } else {
                res.val = l2.val;
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }//while

        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
//            p.next = l2.next;不能是p.next = l2.next
            p.next = l2;
        }
        // ListNode res = new ListNode(0)因为第一个结点是0，所以这里是 res.next,而不是res
        return res.next;
    }


}
