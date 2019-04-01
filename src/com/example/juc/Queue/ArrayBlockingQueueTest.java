package com.example.juc.Queue;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

/**

 * @author qinxuewu
 * @create 19/3/30上午10:37
 * @since 1.0.0
 */


public class ArrayBlockingQueueTest {

    public static void main(String[] args) throws InterruptedException {

        Object[] data=new Object[5];
        System.err.println(data.length);

        ArrayBlockingQueue queue=new ArrayBlockingQueue<>(2,false);
        queue.put(1);
        queue.put(2);
        System.err.println("take:"+queue.take());
//        queue.put(2);
//        for (int i = 0; i < 5; i++) {
//            queue.put(i);
//
//        }
//
//        System.err.println("队列长度："+queue.size());
//        System.err.println("take:"+queue.take());
////        queue.put(6);
//        System.err.println("队列长度："+queue.size());


    }
}
