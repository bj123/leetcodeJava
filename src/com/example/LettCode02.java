package com.example;

import java.util.Stack;

/**
 * 两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * @author qinxuewu
 * @version 1.00
 * @time  28/3/2019 上午 10:02
 * @email 870439570@qq.com
 */
public class LettCode02 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {


    }

    /**
     * 设立一个表示进位的变量carried，建立一个新链表，把输入的两个链表从头往后同时处理，每两个相加，
     * 将结果加上carried后的值作为一个新节点到新链表后面。
     *
     * 将当前结点初始化为返回列表的哑结点。
     * 将进位 carry 初始化为 00。
     * 将 p1 和 p2 分别初始化为列表 l1 和 l2 的头部。
     * 遍历列表 l1l1 和 l2l2 直至到达它们的尾端。
     *      将 x 设为结点 p1 的值。如果 p1 已经到达 l1 的末尾，则将其值设置为 0。
     *      将 y 设为结点 p2 的值。如果 p2 已经到达 l2 的末尾，则将其值设置为 0。
     *      设定 sum = x + y + carry
     *      更新进位的值，carry = sum / 10
     *      创建一个数值为 (sum mod 10) 的新结点，并将其设置为当前结点的下一个结点，然后将当前结点前进到下一个结点。
     *      同时，将 p1 和 p2 前进到下一个结点。
     * 检查 carry =  是否成立，如果成立，则向返回列表追加一个含有数字 1 的新结点。
     * 返回哑结点的下一个结点。
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1=l1;
        ListNode p2=l2;
        ListNode dummyHead=new ListNode(-1);
        ListNode cur=dummyHead;

        int carry = 0;
        while (p1 !=null || p2!=null){
            int x = (p1 != null) ? p1.val : 0;
            int y = (p2 != null) ? p2.val : 0;
            int sum=carry+x+y;
            carry=sum/10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }
        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummyHead.next;
    }


}
