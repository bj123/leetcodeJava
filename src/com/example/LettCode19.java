package com.example;

/**
 *
 * 删除链表的倒数第N个节点
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * @author qinxuewu
 * @version 1.00
 * @time  7/5/2019 下午 12:24
 * @email 870439570@qq.com
 */
public class LettCode19 {

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
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=null;

        ListNode node=removeNthFromEnd2(head,3);

        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }

    /**
     * 两次遍历解决：首先计算链表的长度，
     *
     *  然后设置一个指向哑结点的指针，并移动它遍历列表，直至它到达第 (L - n) 个结点那里。
     *  我们把第 (L-n)个结点的 next 指针重新链接至第 (L−n+2) 个结点，完成这个算法。
     *
     *  注意点：如果是删除第一个节点 也就是头节点了 所有这里要构造一个空头节点保存当前传入的head
     *
     *  时间复杂度：O(L)  空间复杂度：O(1)O(1)，我们只用了常量级的额外空间
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //构造一个空的头节点 next指向当前head. 是为了方便删除head第一个节点时使用
        ListNode root=new ListNode(0);
        root.next=head;



        int length=0;
        //计算出链表的长度
        ListNode first = head;
        while (first != null) {
            length++;
            first = first.next;
        }
        System.err.println("链表长度："+length);
        System.err.println("删除倒数第："+n+" 个节点");
        if(length==n){
            //说明是删除头节点
        }
        //计算出要删除的倒数节点n需要遍历的次数，
        int index=length-n;

        System.err.println("要删除倒数节点前一个节点需要遍历的次数："+index);
        first = root;
        //遍历链表 ,因为first指向了一个含有空的头节点的单链表，所有其实这里找到的是删除倒数位置节点的前一个节点. 改变删除节点前一个节点的next指向即可
        while (index>0){
            index--;
            first = first.next;
        }
        //改变删除节点的前一个节点的next指向
        first.next = first.next.next;
        return root.next;
    }


    /**
     * 一次遍历算法
     *
     * 使用两个指针而不是一个指针。第一个指针从列表的开头向前移动 n+1 步，而第二个指针将从列表的开头出发
     * 这两个指针被 n 个结点分开。我们通过同时移动两个指针向前来保持这个恒定的间隔，直到第一个指针到达最后一个结点
     * 此时第二个指针将指向从最后一个结点数起的第 n 个结点。我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        //构造一个空的头节点 next指向当前head. 是为了方便删除head第一个节点时使用
        ListNode root=new ListNode(0);
        root.next=head;

        System.err.println("删除倒数第："+n+" 个节点");
        int index=n+1;
        System.err.println("要删除倒数节点前一个节点需要遍历的次数："+index);

        ListNode first=root;
        ListNode second =root;

        for (int i = 0; i <index; i++) {
            first=first.next;
        }

        /**
         * 通过同时移动两个指针向前来保持这个恒定的间隔 直到第一个指针到达最后一个结点
         * 此时第二个指针将指向从最后一个结点数起的第 n 个结点
         *
         * 两次加起来的遍历次数 等于只比遍历一次了
         */
        while (first!=null){
            first = first.next;
            second=second.next;
        }
        second.next = second.next.next;
        return root.next;
    }

}
