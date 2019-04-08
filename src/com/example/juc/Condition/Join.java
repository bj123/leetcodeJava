package com.example.juc.Condition;

/**
 * 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
 * @author qinxuewu
 * @version 1.00
 * @time  15/3/2019 下午 3:06
 * @email 870439570@qq.com
 */
public class Join {

    public  static  class MyThread1 extends  Thread{
        public  MyThread1(String name){
            setName(name);
        }

        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1线程执行");
        }
    }

    public  static  class MyThread2 extends  Thread{
        public  MyThread2(String name){
                setName(name);
        }

        public void run() {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2线程执行");
        }
    }

    public  static  class MyThread3 extends  Thread{
        public  MyThread3(String name){
            setName(name);
        }

        public void run() {
            System.out.println("t3线程执行");
        }
    }

    public static void main(String[] args)  throws InterruptedException{
       // 现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
        MyThread1 t1=new MyThread1("thread-t1");

        MyThread2 t2=new MyThread2("thread-t1");

        MyThread3 t3=new MyThread3("thread-t1");

        t1.start();
        //等待t1结束，这时候t2线程并未启动
        t1.join();

        t2.start();
        //等待t2结束
        t2.join();

        t3.start();
//        t3.join();  //等待t3结束  main才输出
        System.out.println("end-----------");

    }
}
