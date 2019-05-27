package com.example.suanfa;


/**
 *
 * 删除链表的中间节点
 *
 *     例如：
 *     不删除任何节点；
 *     1->2,           删除节点1
 *     1->2->3,        删除节点2
 *     1->2->3->4,     删除节点2
 *     1->2->3->4->5,  删除节点3
 *
 *
 * 给定链表的头节点head,整数a和整数b，实现删除位于(a/b)处节点的函数。
 *
 *     1->2->3->4->5，假设a/b的值为r。
 *     如果r等于0，不删除任何节点；
 *     如果r在区间(0,1/5]上，删除节点1；
 *     如果r在区间(1/5,2/5]上，删除节点2；
 *     如果r在区间(2/5,3/5]上，删除节点3；
 *     如果r在区间(3/5,4/5]上，删除节点4；
 *     如果r在区间(4/5,1]上，删除节点5；
 *     如果r大于1，不删除任何节点。
 *
 * @author blog.qinxuewu.club
 * @version 1.00
 * @time  10/5/2019 上午 10:10
 */
public class ListNode02 {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    /**
     * 删除链表的中间节点
     * 如果链表长度为空或1则不需要调整直接返回
     * 如果链表长度为2 则将头节点删除
     * 长度为3  删除第2个， 长度为四，删除第二个
     * 长度为5 删除第三个，
     * 也就是链表长度每增加2 要删除的节点就后移动一个节点。
     * 如果要删除一个节点 则要先找删除节点的前一个节点
     *
     * @param head
     * @return
     */
    public static Node removeMidNode(Node head) {
//        如果链表长度为空或1则不需要调整直接返回
       if(head==null ||head.next==null){
           return head;
       }
       Node pre=head;
       Node cur=head.next.next;
//       也就是链表长度每增加2 要删除的节点就后移动一个节点。
       while (cur.next != null && cur.next.next != null) {
            pre=pre.next;
            cur = cur.next.next;
       }
        pre.next = pre.next.next;
        return head;
    }

//    给定链表的头节点head,整数a和整数b，实现删除位于(a/b)处节点的函数。
    public static Node removeByRatio(Node head, int a, int b) {
        if (a < 1 || a > b) {
            return head;
        }
        int n = 0;
        Node cur = head;
        while (cur != null) {
            n++;
            cur = cur.next;
        }
        n = (int) Math.ceil(((double) (a * n)) / (double) b);
        if (n == 1) {
            head = head.next;
        }
        if (n > 1) {
            cur = head;
            while (--n != 1) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
