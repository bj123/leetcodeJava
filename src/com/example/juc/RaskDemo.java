package com.example.juc;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.TimeUnit;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author qinxuewu
 * @create 19/3/30下午1:07
 * @since 1.0.0
 */


public class RaskDemo extends RecursiveAction {

    /**bb
     *  每个"小任务"最多只打印20个数
     */
    private static final int MAX = 5;

    private int start;
    private int end;
    private List<String> list;
    public RaskDemo(int start, int end,List<String> list) {
        this.start = start;
        this.end = end;
        this.list=list;
    }

    @Override
    protected void compute() {
        //当end-start的值小于MAX时，开始打印
        if((end-start) < MAX) {
            for(int i= start; i<end;i++) {
                System.out.println(Thread.currentThread().getName()+"list.get(i);的值"+list.get(i));
            }
        }else {
            System.out.println("任务拆分执行");
            // 将大任务分解成两个小任务
            int middle = (start + end) / 2;
            RaskDemo left = new RaskDemo(start, middle,list);
            RaskDemo right = new RaskDemo(middle, end,list);
            left.fork();
            right.fork();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建包含Runtime.getRuntime().availableProcessors()返回值作为个数的并行线程的ForkJoinPool
        List<String> lists=Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15");
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // 提交可分解的PrintTask任务
        forkJoinPool.submit(new RaskDemo(0, lists.size(),lists));

        //阻塞当前线程直到 ForkJoinPool 中所有的任务都执行结束
//        forkJoinPool.awaitTermination(2, TimeUnit.SECONDS);

        // 关闭线程池
//        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(30, TimeUnit.SECONDS);
        System.out.println("dadasdsa");


    }
}
