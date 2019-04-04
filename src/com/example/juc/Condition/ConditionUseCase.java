package com.example.juc.Condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionUseCase {
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    //等待
    public void await() {
        try {
            lock.lock();    //调用lock.lock()方法的线程就持有了"对象监视器"，其他线程只有等待锁被释放时再次争抢
            System.out.println("await()时间为：" + System.currentTimeMillis());
            condition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    //通知
    public void signal() {
        try {
            lock.lock();
            System.out.println("signal()时间为：" + System.currentTimeMillis());
            condition.signal();
        } finally {
            lock.unlock();
        }
    }

    //线程类
   static class ThreadA extends Thread {
        private ConditionUseCase test;
        public ThreadA(ConditionUseCase test) {
            super();
            this.test = test;
        }

        public void run() {
            test.await();
        }
    }

    public static void main(String[] args) throws InterruptedException  {
        ConditionUseCase test=new ConditionUseCase();
        ThreadA a = new ThreadA(test);
        a.start();
        System.out.println(Thread.currentThread().getName()+"线程执行");
        Thread.sleep(3000);
        test.signal();
    }
}
