package com.example.juc.AQS;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author qinxuewu
 * @create 19/3/19上午8:18
 * @since 1.0.0
 */


public class MyAQSLockTest {
    MyAQSLock lock=new MyAQSLock();
    private    int i=0;
    public  int  next() {
        try {
            lock.lock();
            try {
                Thread.sleep(300);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return i++;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return 0;
    }

    public void test1(){
        System.out.println("test1");
        test2();
    }
    public  void  test2(){
        System.out.println("test2");
    }

    public static void main(String[] args){
        MyAQSLockTest test=new MyAQSLockTest();
//         Thread thread = new Thread(new Runnable() {
//
//            public void run() {
//                while (true) {
//
//                    System.out.println(Thread.currentThread().getName() + "-" + test.next());
//
//                }
//
//            }
//        });
//        thread.start();
//
//        Thread thread2 = new Thread(new Runnable() {
//
//            public void run() {
//                while (true) {
//
//                    System.out.println(Thread.currentThread().getName() + "-" + test.next());
//
//                }
//
//            }
//        });
//        thread2.start();

        //可重复锁演示
        Thread thread3 = new Thread(new Runnable() {

            public void run() {
                test.test1();

            }
        });
        thread3.start();
    }
}
