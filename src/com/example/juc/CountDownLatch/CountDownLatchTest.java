package com.example.juc.CountDownLatch;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.concurrent.CountDownLatch;

/**
 * 在完成一组正在其他线程中执行的操作之前，它允许一个或多个线程一直等待
 CountDownLatch是通过一个计数器来实现的，当我们在new 一个CountDownLatch对象的时候需要带入该计数器值，
 该值就表示了线程的数量。每当一个线程完成自己的任务后，计数器的值就会减1。
 当计数器的值变为0时，就表示所有的线程均已经完成了任务，然后就可以恢复等待的线程继续执行了。
 *
 * CountDownLatch的计数器无法被重置  只能使用一次
 * @author qinxuewu
 * @create 19/3/21下午9:26
 * @since 1.0.0
 */


public class CountDownLatchTest {
    static CountDownLatch c=new CountDownLatch(2);
    static CountDownLatch countDownLatch=new CountDownLatch(3);
    //汇总任务
    static class T1 extends Thread{
        @Override
        public void run() {
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("所有表格已经读取完了，进行汇总处理");
        }
    }

    //批量处里表格数据任务
    static class task  extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "：开始处理表格数据");
            //处理完计数器就减1
            countDownLatch.countDown();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        System.out.println("初始化任务数："+c.getCount());
        new Thread(()->{
            System.out.println("任务1执行");
            c.countDown();
            System.out.println("任务2执行");
            c.countDown();
        }).start();;
        c.await();
        System.out.println("任务执行完毕！");

//        new T1().start();
//        for (int i = 1; i <=3; i++) {
//            new task().start(); //多线程读取表格
//        }

    }


}
