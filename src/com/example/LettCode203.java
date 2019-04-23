package com.example;

/**
 *  移除链表元素
 *
 *  删除链表中等于给定值 val 的所有节点。
 *
 *  输入: 1->2->6->3->4->5->6, val = 6
 *  输出: 1->2->3->4->5
 *
 *
 * @author qinxuewu
 * @version 1.00
 * @time  23/4/2019 上午 10:38
 * @email 870439570@qq.com
 */
public class LettCode203 {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(6);
        head.next.next.next=new ListNode(3);
        head.next.next.next.next=new ListNode(4);
        head.next.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next.next=new ListNode(6);
        head.next.next.next.next.next.next.next=null;

        LettCode203 code=new LettCode203();
        ListNode newNode=code.removeElements(head,6);
        while (newNode!=null){
            System.out.println(newNode.val);
            newNode=newNode.next;
        }

    }
    /**
     * 删除链表的元素的前提是，需要找到删除的节点的前一个节点，并把它指向删除节点的next的指向节点
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        //构造一个虚拟头结的辅助链表  并把next执行传入需要遍历的节点
        ListNode header = new ListNode(-1);
        header.next=head;

        //记录当前遍历的节点,
        ListNode cur=header;
        //开始遍历 ,
        while (cur.next!=null){
            if(cur.next.val==val){
                cur.next=cur.next.next;
            }else{
                cur=cur.next;
            }
        }
            //返回辅助节点的next指向 就是删除后的节点数据
            return header.next;
    }
}
