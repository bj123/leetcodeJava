package com.example.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 *  基于AQS实现一个简单的锁
 *
 * @author qinxuewu
 * @create 19/3/18下午11:44
 * @since 1.0.0
 */


public class MyAQSLock implements Lock {
    private  final  MySync sync=new MySync();

    /**
     * 构建一个内部帮助器 集成AQS
     */
    private  static  class MySync extends AbstractQueuedSynchronizer{

    }

    @Override
    public void lock() {

    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    /**
     * 加锁
     * @return
     */
    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    /**
     * 释放锁
     */
    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
