package com.example;

/**
 *
 * 设计链表
 *
 * get(index)：获取链表中第 index 个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为 val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的第 index 个节点之前添加值为 val  的节点。如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
 * deleteAtIndex(index)：如果索引 index 有效，则删除链表中的第 index 个节点。
 *
 * @author qinxuewu
 * @create 19/5/4上午9:39
 * @since 1.0.0
 */


public class LettCode707 {
    public static class Node{
        int val;
        Node next;
        Node(int x,Node next) {
            this.val = x;
            this.next=next;

        }
    }

    private Node head;
    private   int szie;
    public LettCode707() {
      this.szie=0;
    }

    /**
     * 获取指定位置的节点值
     * @param index
     * @return
     */
    public int get(int index) {
            if(index>=this.szie || index <0){
                return  -1;
            }else{
                Node temp=head;
                for (int i = 0; i <index ; i++) {
                    temp=temp.next;
                }
                return  temp.val;
            }
    }

    /**
     * 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点
     * @param val
     */
    public void addAtHead(int val) {
        Node cur=new Node(val,head);
        head=cur;
        szie++;
    }

    /**
     * 将值为 val 的节点追加到链表的最后一个元素
     * @param val
     */
    public void addAtTail(int val) {
        if(this.szie==0){
             head=new Node(val,null);
        }else{

            Node temp=head;
           while (temp.next!=null){
               temp=temp.next;
           }
            temp.next=new Node(val,null);
        }
        this.szie++;
    }

    /**
     *
     * 在链表中的第 index 个节点之前添加值为 val  的节点。
     * 如果 index 等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if(index>this.szie || index<0){
            return;
        }
       if(index==szie){
            addAtTail(val);
            return;
       }
       if(index==0){
            addAtHead(val);
       }

       //找到index位置的前一个节点
       Node pre=head;
       for (int i = 0; i <index-1 ; i++) {
           pre=pre.next;
       }

       //当前index位置的节点
       Node indexNode=pre.next;
       //添加新节点 并把新节点的next执行当前index位置的节点
       pre.next=new Node(val,indexNode);

        this.szie++;

    }

    /**
     *
     * 如果索引 index 有效，则删除链表中的第 index 个节点
     * @param index
     */
    public void deleteAtIndex(int index) {
        if(index>this.szie || index<0){
            return;
        }
        if(index==0){
            head = head.next;
            return;
        }
        //删除指定位置的节点 首先要找到删除节点的前一个节点 让后把pre的next指向当前删除节点的next
        //找到index位置的前一个节点
        Node pre=head;
        for (int i = 0; i <index-1 ; i++) {
            pre=pre.next;
        }
        pre.next=pre.next.next;
        this.szie--;

    }

    public static void main(String[] args) {
        LettCode707 code=new LettCode707();
        code.addAtIndex(0,0);
        code.addAtIndex(1,1);
        code.addAtIndex(2,2);
        code.addAtIndex(3,3);

        code.addAtHead(10);
        code.addAtTail(11);
        code.addAtIndex(1,1010);
        code.addAtIndex(code.szie,100);

        code.deleteAtIndex(7);
         Node node=code.head;
         while (node!=null){
             System.out.println(node.val);
             node=node.next;
         }


    }
}
