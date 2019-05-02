package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 链表的中间结点
 * @author qinxuewu
 * @create 19/5/2下午5:09
 * @since 1.0.0
 */


public class LettCode876 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(6);;
        head.next.next.next.next.next.next=null;

        ListNode middleNode=middleNode(head);
        System.out.println(middleNode.val);
    }

    /**
     * 解法1：输出到数组 然后去中间值
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        List<ListNode> list=new ArrayList<>();
        while (head!=null){
                list.add(head);
                head=head.next;
        }



        int middle=list.size()/2;
        return  list.get(middle);

    }

    /**
     * 解法12：快慢指针法
     *      当用慢指针 slow 遍历列表时，让另一个指针 fast 的速度是它的两倍。当 fast 到达列表的末尾时，slow 必然位于中间。
     * @param head
     * @return
     */
    public static ListNode middleNode2(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
