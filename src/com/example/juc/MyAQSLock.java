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
        //状态为0时获取锁，

        /***
         * 一个线程进来时，如果状态为0，就更改state变量，返回true表示拿到锁
         *
         * 当state大于0说明当前锁已经被持有，直接返回false,如果重复进来，就累加state,返回true
         * @param arg
         * @return
         */
        @Override
        protected boolean tryAcquire(int arg) {
            //获取同步状态状态的成员变量的值
            int state=getState();
            Thread cru=Thread.currentThread();
            if(state==0){
                //CAS方式更新state，保证原子性，期望值，更新的值
                if( compareAndSetState(0,arg)){
                    //设置成功
                    //设置当前线程
                    setExclusiveOwnerThread(Thread.currentThread());
                    return  true;
                }
            }else if(Thread.currentThread()==getExclusiveOwnerThread()){
                    //如果还是当前线程进来，累加state,返回true  可重入
                    setState(state+1);
                    return  true;
            }
            return false;
        }

        /**
         * 释放同步状态
         * @param arg
         * @return
         */
        @Override
        protected boolean tryRelease(int arg) {
            boolean flag=false;
            //判断释放操作是否是当前线程，
            if(Thread.currentThread()==getExclusiveOwnerThread()){

                    //获取同步状态成员变量，如果大于0 才释放
                    int state=getState();
                    if(getState()==0){
                        //当前线程置为null
                        setExclusiveOwnerThread(null);
                        flag=true;
                    }
                    setState(arg);

            }else{
                //不是当线程抛出异常
                throw  new RuntimeException();
            }
            return flag;
        }
        Condition newCondition(){
            return  new ConditionObject();
        }
    }

    @Override
    public void lock() {
            sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    /**
     * 加锁
     * @return
     */
    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return sync.tryAcquireNanos(1,unit.toNanos(time));
    }

    /**
     * 释放锁
     */
    @Override
    public void unlock() {
        sync.tryRelease(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }
}
