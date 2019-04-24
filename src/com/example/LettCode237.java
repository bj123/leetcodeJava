package com.example;

/**
 *  237. 删除链表中的节点
 *
 *  请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点，你将只被给定要求被删除的节点。
 *
 * 输入: head = [4,5,1,9], node = 5
 * 输出: [4,1,9]
 * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 *
 * @author qinxuewu
 * @version 1.00
 * @time  24/4/2019 上午 9:54
 * @email 870439570@qq.com
 */
public class LettCode237 {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        ListNode node=new ListNode(4);
        node.next=new ListNode(5);
        node.next.next=new ListNode(1);
        node.next.next.next=new ListNode(9);
        node.next.next.next.next=null;


        deleteNode(node.next);

        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }

    }

    /**
     * 链表至少包含两个节点。
     * 链表中所有节点的值都是唯一的。
     * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
     * 不要从你的函数中返回任何结果。
     *
     *  从链表里删除一个节点 node 的最常见方法是修改之前节点的 next 指针，使其指向之后的节点。
     *  因为我们无法访问我们想要删除的节点之前的节点，我们始终不能修改该节点的 next 指针。
     *  相反，我们必须将想要删除的节点的值替换为它后面节点中的值，然后删除它之后的节点。
     *  因为我们知道要删除的节点不是列表的末尾，所以我们可以保证这种方法是可行的。
     *
     *  时间和空间复杂度都是：O(1)O(1)。
     * @param node
     * @param x
     */
    public static void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }


}
