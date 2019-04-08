package com.example.juc;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * volatile的内存语义
 *
 *
 * @author qinxuewu
 * @create 19/4/5上午11:23
 * @since 1.0.0
 */


public class VolatileTest {



    private  int  count;  //普通变量
    private  volatile  boolean falg;  //volatile 修饰的变量

    //写操作
    public  void  writer(){
            count=1;
            falg=true;
        }

    // 读操作
    public  void reader(){
        if(falg){                   //3
            int  sum=count+1;       // 4
            System.out.println(sum);  //5
        }
    }

    /**
     *  假设有两个线程：线程A调用写方法， 线程B调用读方法
     *  如果falg不是volatile修饰的，那么操作1和操作2之间没有数据依赖性，
     *  处理器可能会对这个操作进行重排序，这时线程A正好执行先执行了操作2，然后这时线程B抢先执行了操作3
     *  发现为true就执行if语句里的运行， 得到值可能就是1，而不是我们所预想的输出sum=2。
     *
     *
     *
     * @param args
     */

    public static void main(String[] args) {


        String a="123";
        String b="123";
        String c=new String("123");
        String d=c;
        System.out.println(a.equals(b));
        System.out.println(a==b);
        System.out.println(a.equals(c));
        System.out.println(a==c);
        System.out.println(d==c);
        System.out.println(d.equals(a));
        System.out.println(d.equals(c));


    }
}
