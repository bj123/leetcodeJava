package com.example.juc.Semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Semaphore;

/**
 *
 *
 * 控制线程的并发数
 *
 * @author qinxuewu
 * @create 19/3/23下午12:38
 * @since 1.0.0
 */


public class SemaphoreTest {
    static Semaphore s=new Semaphore(3);

    static  class Task implements   Runnable{
        @Override
        public void run() {

            try {
                s.acquire();  //获取一个许可
                System.out.println(Thread.currentThread().getName()+" 获取一个许可开始执行...");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName()+" 退出。");
            }catch (Exception e){
            }finally {
                s.release();  //规划一个许可
            }
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i <=5 ; i++) {
            new Thread(new Task()).start();
        }
    }
}
