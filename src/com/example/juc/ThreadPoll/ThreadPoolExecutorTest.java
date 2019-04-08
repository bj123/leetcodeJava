package com.example.juc.ThreadPoll;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author qinxuewu
 * @create 19/3/31下午12:32
 * @since 1.0.0
 */


public class ThreadPoolExecutorTest {

    // 命名线程工厂
    static class NamedThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        NamedThreadFactory(String name) {

            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            if (null == name || name.isEmpty()) {
                name = "pool";
            }

            namePrefix = name + "-" + poolNumber.getAndIncrement() + "-thread-";
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }

    public static void main(String[] args) {
        /**
         * corePoolSize: 初始化指定的核心线程数量
         * maximumPoolSize ： 允许的最大线程数。  如果当前的线程数小于maximumPoolSize，则会新建线程来执行任务。注意，如果使用的是无界队列，该参数也就没有什么效果了。
         * keepAliveTime： 线程空闲的时间 默认情况下，该参数只有在线程数大于corePoolSize时才会生效。
         * unit： keepAliveTime的单位
         * workQueue： 保存等待执行的任务的阻塞队列 等待的任务必须实现Runnable接口。我们可以选择如下几种：ArrayBlockingQueue，LinkedBlockingQueue，SynchronousQueue，PriorityBlockingQueue
         * threadFactory：  用于设置创建线程的工厂。不指定 则是默认 Executors.defaultThreadFactory()
         * defaultHandler： 线程池的拒绝策略。线程池中的线程已经饱和了，而且阻塞队列也已经满了，则线程池会选择一种拒绝策略来处理该任务
         *
         *              线程池提供的四种拒绝策略，也可以实现自己的拒绝策略：
         *
         *                      AbortPolicy：直接抛出异常，默认策略；
         *                      CallerRunsPolicy：用调用者所在的线程来执行任务；
         *                      DiscardOldestPolicy：丢弃阻塞队列中靠最前的任务，并执行当前任务；
         *                      DiscardPolicy：直接丢弃任务；
         */
        ThreadPoolExecutor executor=new
                ThreadPoolExecutor(1,1,
                10,TimeUnit.SECONDS,new ArrayBlockingQueue<>(1),new NamedThreadFactory("test-poll"),new ThreadPoolExecutor.CallerRunsPolicy());
        for (int i = 0; i <5 ; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }


        executor.shutdown();
    }
}
