package com.example.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

  Lock lock=new ReentrantLock();

  public void  test1(){
      Lock lock=new ReentrantLock();
      lock.lock(); //获取锁
      try {
         System.out.println("test111");
      }catch (Exception e){

      }finally {
          lock.unlock(); //释放锁
      }
  }

    public void  test2(){
        Lock lock=new ReentrantLock();
        try {
            lock.lockInterruptibly();   //能被中断的获取锁

            System.out.println("test2");
        }catch (Exception e){

        }finally {
            lock.unlock(); //释放锁
        }
    }


    public static void main(String[] args) {

    }
}
