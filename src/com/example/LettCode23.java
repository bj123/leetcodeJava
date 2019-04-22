package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 23. 合并K个排序链表
 *
 *  合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
      输入:
     [
       1->4->5,
       1->3->4,
       2->6
     ]
     输出: 1->1->2->3->4->4->5->6
 *
 * @author qinxuewu
 * @create 19/4/21上午9:15
 * @since 1.0.0
 */


public class LettCode23 {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }

    }

    public static void main(String[] args) {
        ListNode head1=new ListNode(1);
        head1.next=new ListNode(4);
        head1.next.next=new ListNode(5);
        head1.next.next.next=null;


        ListNode head2=new ListNode(1);
        head2.next=new ListNode(3);
        head2.next.next=new ListNode(4);
        head2.next.next.next=null;


        ListNode head3=new ListNode(2);
        head3.next=new ListNode(6);
        head3.next.next=null;

        ListNode [] ListNode={head1,head2,head3};
        LettCode23 code =new LettCode23();
        ListNode node=code.mergeKLists(ListNode);

    }

    /**
     *  先放入集合排序 在合并
     *  把每个结节点的数据取出来放入集合中 然后在排序  生成一个链表返回
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <=lists.length-1; i++) {
            ListNode head=lists[i];

            while (head!=null){
                System.out.println(head.val);
                list.add(head.val);
                head=head.next;
            }
        }

        if(list.size()==0){
            return  null;
        }
        Collections.sort(list);
        System.out.println("排序后的list: "+Arrays.toString(list.toArray()));

        //生成排序后的链表返回
        ListNode node=new ListNode(0);
        ListNode cur=node;
        for (int j = 0; j <list.size() ; j++) {
            int val=list.get(j);
            cur.next=new ListNode(val);
            cur=cur.next;
        }
        return node.next;
    }
}
