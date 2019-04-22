package com.example;


import java.util.LinkedList;
import java.util.Queue;

/**
 *   用队列实现栈
 *
 * @author qinxuewu
 * @version 1.00
 * @time  22/4/2019 下午 12:15
 * @email 870439570@qq.com
 */
public class LettCode225 {

   private Queue<Integer> queue;
   private  Queue<Integer> tempQueue;
   public LettCode225() {
        queue=new LinkedList<>();
        tempQueue=new LinkedList<>();
    }

    /**
     * 用一个临时队列调换元素位置。
     * push操作时 先添加到临时队里中
     * 然后判断存储数据的队列不为空时，就把数据全部放入临时队列
     * 最后判断临时队列是否为空，不为空则全部放入数据队列中
     * @param x
     */
    public void push(int x) {
        /**
         *  第一次 push=1。queue={1},tempQueue={}
         */
        tempQueue.add(x);


        /**
         *  第二次 push=2  tempQueue={2,1},queue={}
         */
        while (!queue.isEmpty()){
            tempQueue.add(queue.poll());
        }

        /**
         *  第二次 push=2。tempQueue={1,2}
         */
        while (!tempQueue.isEmpty()){

            queue.add(tempQueue.poll());
        }
    }

    public int pop() {
        return  queue.poll();
    }

    public int top() {
        return  queue.peek();
    }

    public boolean empty() {
            return  queue.isEmpty();
    }

    public static void main(String[] args) {
        LettCode225 code=new LettCode225();
        code.push(1);
        code.push(2);
        code.push(3);
        System.out.println(code.top()); // 3
        System.out.println(code.pop()); // 3
        System.out.println(code.pop()); // 2
        code.push(4);
        System.out.println(code.pop()); // 4
    }

}
