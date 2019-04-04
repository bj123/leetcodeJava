package com.example.juc.ReentrantLock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author qinxuewu
 * @create 19/3/18下午9:20
 * @since 1.0.0
 */


public class ReentrantLockTest {
    private static ReentrantLock lock=new ReentrantLock();
    private  int i=0;
    public  void  a(){
        lock.lock();
        i++;

        lock.unlock();


    }

    public static void main(String[] args) {
        ReentrantLockTest t=new ReentrantLockTest();
        for (int i = 0; i <100 ; i++) {
            new Thread(new Runnable() {

                public void run() {
                        t.a();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
        System.out.print(t.i);
    }
}
