package com.example.suanfa;

import java.util.Stack;

/**
 * 用一个栈实现另一个栈的排序
 *
 * 一个栈中的元素类型为整型，现在想将该栈从顶到底从大到小的顺序排序
 * 只许申请一个栈，除此之外，可以申请新的变量，但不能申请额外的数据结构 如何完成排序
 *
 * @author qinxuewu
 * @version 1.00
 * @time  15/4/2019 下午 6:16
 * @email 870439570@qq.com
 */

public class Stack04 {



    /**
     *  将要排序的栈标记为stack, 申请辅助的栈标记为help
     *  在stack执行弹出操作，弹出的元素记为cur
     *      如果 cur小于或等于help栈顶元素 则将cur压入help
     *      如果 cur大于help栈顶元素 则将help元素逐一弹出压入到stack,直到cur小于或等于help栈顶元素
     *
     *      最后将cur压入help
     *
     * @param stack
     */
    public  static  void  sortStack(Stack<Integer> stack){
        Stack<Integer> help=new Stack<>();
        while (!stack.isEmpty()){
                int cur=stack.pop();
            while (!help.isEmpty() && help.peek() > cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }

        while (!help.isEmpty()){
                stack.push(help.pop());
        }
    }



    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(3);
        stack.push(1);
        stack.push(6);
        stack.push(2);
        stack.push(5);
        stack.push(4);
        sortStack(stack);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

}
