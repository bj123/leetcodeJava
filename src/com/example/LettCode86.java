package com.example;

/**
 * 86. 分隔链表
 *
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 *
 *
 * @author qinxuewu
 * @version 1.00
 * @time  18/4/2019 上午 9:40
 * @email 870439570@qq.com
 */
public class LettCode86 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(4);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(2);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(2);
        head.next.next.next.next.next.next=null;

        LettCode86 code=new LettCode86();

        ListNode node=code.partition(head,3);
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }

    /**
     * 解题思路：
     *          这道题主要是利用两个临时头结点less,more来分割，
     *          遍历链表，小于x 放在less结点中。大于x放入more结点中
     *          最后拼接h返回less结点
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        //设置两个临时头结点
        ListNode  less_head=new ListNode(0);
        ListNode more_head=new ListNode(0);

        //两个临时结点 ，指向两个头结点
        ListNode less_ptr = less_head;
        ListNode more_pty = more_head;
        while (head!=null){
            //如果结点小于x 则插入
            if(head.val<x){
                //链接完成后,less_ptr向后移动 指向head
                less_ptr.next=head;
                less_ptr=head;

            }else{
                more_pty.next=head;
                more_pty=head;
            }
            //继续遍历链表
            head=head.next;
        }
        // 将 less链表尾与more链表头相连
        less_ptr.next=more_head.next;

        //最后   将more_ptr即链表尾节点next置为空
        more_pty.next=null;

        //返回less_head的next 去除默认的0
        return less_head.next;
    }
}
