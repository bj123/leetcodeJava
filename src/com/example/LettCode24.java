package com.example;

/**
 * 24. 两两交换链表中的节点
 *  你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *  给定 1->2->3->4, 你应该返回 2->1->4->3.
 * @author qinxuewu
 * @create 19/5/4下午12:07
 * @since 1.0.0
 */


public class LettCode24 {


    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 递归解法
     *  找终止条件：本题终止条件很明显，当递归到链表为空或者链表只剩一个元素的时候，没得交换了，自然就终止了。
     *  找返回值：返回给上一层递归的值应该是已经交换完成后的子链表。
     *  单次的过程：因为递归是重复做一样的事情，所以从宏观上考虑，只用考虑某一步是怎么完成的。
     *      我们假设待交换的俩节点分别为head和next，next的应该接受上一级返回的子链表(参考第2步)。
     *      就相当于是一个含三个节点的链表交换前两个节点，就很简单了，想不明白的画画图就ok。
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        //终止条件：链表只剩一个节点或者没节点了，没得交换了。返回的是已经处理好的链表
        if(head==null ||head.next==null){
            return  head;
        }
        //一共三个节点:head, next, swapPairs(next.next)
        //下面的任务便是交换这3个节点中的前两个节点
        ListNode next=head.next;
        head.next=swapPairs(next.next);
        next.next = head;
        //根据第二步：返回给上一级的是当前已经完成交换后，即处理好了的链表部分
        return next;
    }


    /**
     * 使用3个指针，分别指向当前，后一个，后第二个，
     * 然后交换后一和后二，最后把当前指针向后移动两个单位
     * @param head
     * @return
     */
    public static ListNode swapPairs2(ListNode head) {
        ListNode cur=new ListNode(-1);
        cur.next=head;


        ListNode p = cur;
        while (p!=null && p.next!=null && p.next.next!=null){

             //记录当前遍历的指针
             ListNode node=p.next;
             //后一个
             ListNode node1=node.next;
             //后第二个
             ListNode node2=node1.next;

             //然后交换后一和后二
             p.next= node1;
             node1.next=node;
             node.next=node2;

            //最后把当前指针向后移动两个单位,继续遍历
            p=p.next.next;
        }
        return cur.next;
    }


    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=null;

        ListNode node=swapPairs2(head);
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }


}
