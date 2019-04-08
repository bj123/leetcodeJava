package com.example.juc;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * 使用Java提供的标准管理API,ThreadMXBean,其直接就提供 了fndDeadlockedThreads﻿()方法用于定位死锁
 * 在实际应用中,就可以据此收集进一步的信息,然后进行预警等后续处理。但是要注意的是,对线程进行快照本身是一个相对重量
 * 级的操作,还是要慎重选择频度和时机。
 *
 * @author qinxuewu
 * @create 19/4/8下午10:55
 * @since 1.0.0
 */


public class ThreadMXBeanTest {
    public static void main(String[] args) {
        ThreadMXBean mbean = ManagementFactory.getThreadMXBean();

        Runnable dlCheck = new Runnable() {
            @Override
            public void run() {
                long[] threadIds = mbean.findDeadlockedThreads();
                if (threadIds != null) {
                    ThreadInfo[] threadInfos = mbean.getThreadInfo(threadIds);
                    System.out.println("Detected deadlock threads:");
                    for (ThreadInfo threadInfo : threadInfos) {
                        System.out.println(threadInfo.getThreadName());
                    }
                }
            }
        };

        ScheduledExecutorService scheduler =Executors.newScheduledThreadPool(1);
        // 稍等5秒,然后每10秒进行一次死锁扫描
        scheduler.scheduleAtFixedRate(dlCheck, 5L, 10L, TimeUnit.SECONDS);
        Test1  t=new Test1();

        new Thread(new Runnable() {
            @Override
            public void run() {
                t.t1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                t.t2();
            }
        }).start();
    }


    public  static  class Test1{
        Object obj1=new Object();
        Object obj2=new Object();

        public void  t1(){
            synchronized (obj1){
                System.out.println(Thread.currentThread().getName()+":    obj1--------");
                try {
                    Thread.sleep(1000);
                    synchronized (obj2){
                        System.out.println(Thread.currentThread().getName()+"   obj2--------");
                    }
                }catch (InterruptedException e){

                }

            }
        }

        public void  t2(){
            synchronized (obj2){
                System.out.println(Thread.currentThread().getName()+"    t2  obj2--------");
                try {
                    Thread.sleep(1000);
                    synchronized (obj1){
                        System.out.println(Thread.currentThread().getName()+"   t2  obj1--------");
                    }
                }catch (InterruptedException e){

                }


            }
        }

    }
}
