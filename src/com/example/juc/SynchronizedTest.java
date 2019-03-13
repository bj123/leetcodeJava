package com.example.juc;

public class SynchronizedTest {
    private static   int i;

    /**
     * 普通方法：锁的是当前实列
     */
    public synchronized void  test1(){
        System.out.print(i++);
    }

    /**
     * 静态方法：锁的是当前类的class对象
     */
    public synchronized static void  test2(){
        System.out.print(i++);
    }


    /**
     * 同步代码块 this是代表当前的对像
     * 当只有访问同一对象，才会同步,和synchronized（Object x）功能类似。
     */
    public void test3(){
        synchronized (this){
            System.out.print(i++);
        }
    }


    /**
     * 同步代码块使用的是非this，对象监视器（锁）
     * 锁的当前同一个obj对象
     */
    Object obj = new Object();
    public void test4(){

        synchronized (obj){
            System.out.print(i++);
        }
    }

    /**
     * 只要是访问这个类的方法，就会同步，不管用这个类创建了几个对象
     * 和静态方法使用synchronized加锁一样
     */
    public void test5(){
        synchronized (SynchronizedTest.class){
            System.out.print(i++);
        }
    }

}