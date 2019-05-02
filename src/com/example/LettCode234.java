package com.example;

import java.util.Stack;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 *
 * @author qinxuewu
 * @version 1.00
 * @time  26/4/2019 上午 9:42
 * @email 870439570@qq.com
 */
public class LettCode234 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }


    /***
     * 普通解法:利用栈的先进后出的特性，依次把链表压入栈中。然后在遍历链表中依次出栈判断是否全部相等
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        Stack<ListNode> stack=new Stack<>();
        ListNode cur=head;
        while (cur!=null){
            stack.push(cur);
            cur=cur.next;
        }
        while (head!=null){
            if(head.val!=stack.pop().val){
                return  false;
            }
            head=head.next;
        }
            return  true;
    }


    /**
     * 解法二：反转一半链表，并同时向中间移动匹配是否相等。都相等则回文
     * @param head
     * @return
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            // 只有一个节点肯定是true
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = null;
        while (fast != null){
            /**
             * 1.快速找到中间的节点
             * 2.将慢指针指向的前半部分翻转
             * 3.从中间开始向左右两边遍历比较
             */
            // 偶数个节点
            if (fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                // 遍历时顺便翻转前半部分
                head.next = temp;
                temp = head;
                head = slow;
            } else { // 奇数个节点
                slow = slow.next;
                // 遍历时顺便翻转前半部分
                head.next = temp;
                head = slow;
                break;
            }

        }
        while (temp != null){
            if (temp.val != head.val) {
                return false;
            }
            temp = temp.next;
            head = head.next;
        }
        return true;
    }
}
