package com.example.juc.ThreadPoll;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author qinxuewu
 * @create 19/4/1下午8:29
 * @since 1.0.0
 */


public class ExecutorServiceTest {
    public static void main(String[] args) {

        /**
         * 创建一个可重用固定的线程池
         * corePoolSize=3
         * maximumPoolSize=3
         * keepAliveTime=0
         * unit： TimeUnit.MILLISECONDS
         * workQueue=LinkedBlockingQueue
         *
         * 用于使用无界阻塞队列，maximumPoolSize是一个无效参数
         *
         *
         */
        ExecutorService poll= Executors.newFixedThreadPool(3);

        /**
         * 创建一个单个worker工作的线程池
         */
        ExecutorService poll2=Executors.newSingleThreadExecutor();

        /**
         * 创建一个根据需要创建新线程的线程池
         * corePoolSize被设置为0
         * maximumPoolSize被设置Integer.MAX_VALUE 无界的
         * keepAliveTime=60  空闲线程等待新任务的时间最长为60秒
         *
         * 使用有容量的SynchronousQueue作为队列，每一个插入操作必须等待另一个线程的移除操作
         */
        ExecutorService poll3=Executors.newCachedThreadPool();


        /**
         * 创建一个在给定的延迟后 运行任务或定期执行任务
         */
        ExecutorService poll4=Executors.newScheduledThreadPool(3);

    }
}
