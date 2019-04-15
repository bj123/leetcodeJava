package com.example.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出演示
 * @author qinxuewu
 * @version 1.00
 * @time  12/4/2019 上午 9:53
 * @email 870439570@qq.com
 */
public class OutOfMemoryTest2 {
    private final  static  int COUNT=2000;

    private byte[] by=new  byte[128*1024];

    public static void main(String[] args) {
        //防止程序运行过快
        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        test();
    }

    public   static  void  test(){
        //防止程序运行过快
        List<OutOfMemoryTest2>  list=new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            list.add(new OutOfMemoryTest2());
        }
    } 
}
