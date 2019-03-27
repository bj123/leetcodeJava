package com.example.juc.CyclicBarrier;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
public class CyclicBarrierTest {
    private static CyclicBarrier c;
    //批量处里表格数据任务
    static class task  extends Thread{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "：开始处理表格数据");
            try {
                //处理完计数器就减1
                c.await();
            }catch (Exception  e){

            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
                //初始化屏障总数，并指定优先执行的方法，该操作由最后一个进入 barrier 的线程执行。
              c=new CyclicBarrier(3, new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("屏障已到达，开始汇总任务执行。。。。");
                    }
                });

        for (int i = 1; i <=3 ; i++) {
                new task().start();
        }
    }
}
