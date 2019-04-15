package com.example.suanfa;
import java.util.Stack;

/**
 *  用两个栈实现一个 队列
 *
 *  栈的特点是先进后出，队列的特点是先进先出。
 *  用两个栈正好能把顺序反过来
 *
 *  注意两点：
 *      如果stackPush要往stackPop压入数据 必须一次性压入所有的
 *      如果stackPop不为空 ，绝不能要人数据
 *
 *
 * @author qinxuewu
 * @version 1.00
 * @time  11/4/2019 上午 10:51
 * @email 870439570@qq.com
 */
public class StackQueue02 {

    /**
     *  队列入队的栈
     */
    Stack<Integer> stackPush;

    /**
     * 队列出队的栈
     */
    Stack<Integer> stackPop;

    public StackQueue02(){
        stackPush=new Stack<>();
        stackPop=new Stack<>();

    }

    /**
     * 入队
     * @param x
     */
    public  void  add(int x){
        stackPush.push(x);
    }

    /**
     * 出队
     * @return
     */
    public  int poll(){
        if(stackPush.isEmpty() && stackPop.isEmpty()){
            throw  new RuntimeException(" Queue is nul");
        }else if(stackPop.isEmpty()){
                //入对的栈数据不为空 则每次循环压入出队的栈中  这样顺序就反过来了
                while (!stackPush.isEmpty()){
                    stackPop.push(stackPush.pop());
                }

        }
        return  stackPop.pop();
    }

    /**
     * 在队列的头部查询元素
     * @return
     */
    public  int peek(){
        if(stackPush.isEmpty() && stackPop.isEmpty()){
            throw  new RuntimeException(" Queue is nul");
        }else if(stackPop.isEmpty()){

            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }

        return  stackPop.peek();
    }

    public static void main(String[] args) {
        StackQueue02 stack=new StackQueue02();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        System.out.println(stack.poll());
        System.out.println(stack.peek());
        stack.add(4);
        stack.add(5);
        System.out.println(stack.poll());
        System.out.println(stack.peek());

    }
}
