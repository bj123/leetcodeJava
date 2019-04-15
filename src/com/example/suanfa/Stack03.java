package com.example.suanfa;
import java.util.Stack;

/**
 *  使用递归函数 和栈操作 逆序一个栈
 * @author qinxuewu
 * @version 1.00
 * @time  12/4/2019 上午 11:33
 * @email 870439570@qq.com
 */
public class Stack03 {

    /**
     * 递归函数: 将栈的栈底元素返回并删除
     * @param stack
     * @return
     */
    public  static  int getAndRemoveLastElement(Stack<Integer> stack){
            int result=stack.pop();
            if(stack.isEmpty()){
                return  result;
            }else{
                //如果不为空 ，递归 继续出栈
                int last=getAndRemoveLastElement(stack);
                stack.push(result);
                return  last;
            }

    }


    public  static  void reverse(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        int value=getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(value);
    }


    public static void main(String[] args) {
        Stack<Integer> stack=new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);


        reverse(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
     }

}
