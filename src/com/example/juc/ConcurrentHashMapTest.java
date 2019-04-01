package com.example.juc;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author qinxuewu
 * @create 19/3/24下午12:50
 * @since 1.0.0
 */


public class ConcurrentHashMapTest {

    public static void main(String[] args) {
        ConcurrentHashMap<String,Integer> map=new ConcurrentHashMap<>();
        for (int i = 0; i <5 ; i++) {
            int finalI = i;
            new Thread(()->{
                map.put("test"+ finalI, finalI);
            }).start();
        }

        for (int i = 0; i <2 ; i++) {
            int finalI = i;
            new Thread(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(map.get("test"+finalI));
            }).start();
        }

    }
}
