package com.example.juc;

import java.util.concurrent.atomic.AtomicInteger;

public class AatomicTest {
    static  AtomicInteger ai = new AtomicInteger(1);

    public static void main(String[] args) {
        ai.getAndIncrement();   //以原子方式将当前值加1，相当于线程安全的i++操作
        ai.getAndDecrement();   // 以原子方式将当前值减1，相当于线程安全的i–操作
        ai.decrementAndGet(); //以原子方式将当前值减1，相当于线程安全的–i操作
    }
}
