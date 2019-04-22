package com.example.suanfa;


/**
 *  打印两个有序链表的公共部分
 * @author qinxuewu
 * @version 1.00
 * @time  22/4/2019 上午 10:53
 * @email 870439570@qq.com
 */
public class NodeTest01 {


    public static class Node{
        int val;
        Node next;
        Node(int x) {
            this.val = x;
        }

    }

    public static void main(String[] args) {
        Node node1=new Node(1);
        node1.next=new Node(2);
        node1.next.next=new Node(3);
        node1.next.next.next=null;

        Node node2=new Node(1);
        node2.next=new Node(2);
        node2.next.next=new Node(6);
        node2.next.next.next=null;

        PrintCommonPart(node1,node2);
    }

    /**
     * 因为是有序 遍历判断相等 打印即可
     * @param node1
     * @param node2
     */
    public  static  void PrintCommonPart(Node node1,Node node2){
            while (node1!=null  &&  node2!=null){
                    if(node1.val< node2.val){
                        node1=node1.next;
                    }else if(node1.val> node2.val){
                         node2=node2.next;

                    }else {
                        System.out.println(node1.val);
                        node1=node1.next;
                        node2=node2.next;
                    }
            }


    }
}
