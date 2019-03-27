package com.example.juc.ThreadLocal;

/**
 * `ThreadLocal` 是一个本地线程副本变量工具类。
 * 主要用于将私有线程和该线程存放的副本对象做一个映射，各个线程之间的变量互不干扰
 *
 * @author qinxuewu
 * @version 1.00
 * @time  25/3/2019 上午 11:04
 * @email 870439570@qq.com
 */
public class ThreadLocalTest {
    ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>(){
        //返回此线程局部变量的当前线程的“初始值”。
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    //   返回此线程局部变量的当前线程副本中的值。
    public int get(){
        //将此线程局部变量的当前线程副本中的值设置为指定值。
        threadLocal.set(threadLocal.get()+1);
        return  threadLocal.get();
    }

    public static void main(String[] args) {
        ThreadLocalTest test=new ThreadLocalTest();
            new Thread(()->{
                for (int i = 0; i <3 ; i++) {
                    int state=test.get();
                    System.out.println(Thread.currentThread().getName()+"获取值："+state);
                }

            }).start();

            new Thread(()->{
                for (int i = 0; i <3 ; i++) {
                    int state=test.get();
                    System.out.println(Thread.currentThread().getName()+"获取值："+state);
                }
            }).start();
    }
}
