package com.example.juc.Queue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 一个基于链接节点的无边界的线程安全队列，它采用先进先出原则对元素进行排序，
 * 插入元素放入队列尾部，出队时从队列头部返回元素，利用CAS方式实现的
 *
 *  https://www.jianshu.com/p/24516e7853d1
 *
 * https://blog.csdn.net/fjse51/article/details/55511475
 * @author qinxuewu
 * @create 19/3/27下午8:55
 * @since 1.0.0
 */


public class ConcurrentLinkedQueueTest {
   private static     ConcurrentLinkedQueue queue=new ConcurrentLinkedQueue();
//    private static ConcurrentLinkedQueue<Integer> queue2 = new ConcurrentLinkedQueue<Integer>();
    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            queue.offer(i);
        }
        System.err.println(queue.size());
        System.err.println("poll:"+queue.poll());
        System.err.println("poll:"+queue.poll());
        System.err.println("poll:"+queue.poll());
        System.err.println("poll:"+queue.poll());
    }
}
