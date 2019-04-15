package com.example;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * 相交链表
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 * @author qinxuewu
 * @create 19/4/16上午12:03
 * @since 1.0.0
 */


public class LettCode160 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public int hashCode() {
            return val+"".hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj ==  null )  return   false ;
            if ( this  == obj)  return   true ;
            if (obj  instanceof  ListNode){
                ListNode node = (ListNode)obj;
                if (val==node.val) return   true ;
            }

            return   false ;
        }
    }

    /**
     * 解法一：
     *      适用set集合存储所有headA结点
     *      在遍历headB，并且判断是否存在set集合中， 如果存在 直接返回链表结点  不存在继续遍历
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //设置查找的集合
        Set<ListNode> set=new HashSet<>();

        while (headA!=null){
            set.add(headA);
            headA=headA.next;
        }

        while (headB!=null){
            //集合中存在 说明链表相交
            if(set.contains(headB)){
                return  headB;
            }
            headB=headB.next;
        }

        return  null;
    }

    public static void main(String[] args) {
        ListNode headA=new ListNode(1);
        headA.next=new ListNode(2);
        headA.next.next=new ListNode(3);
        headA.next.next.next=null;

        ListNode headB=new ListNode(4);
        headB.next=new ListNode(2);
        headB.next.next=null;

        LettCode160 code=new LettCode160();
        System.out.println(code.getIntersectionNode(headA,headB).val);
    }
}
