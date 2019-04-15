package com.example.suanfa;

import java.util.Stack;

/**
 * 实现一个特殊的栈,在实现栈的基础上，再实现返回栈中元素最小的操作
 *
 * 要求：
 *      pop, push,getMin操作的时间复杂度都是O(1)
 *      设计的栈类型可以使用线程的栈结构
 *
 *  实现思路：
 *          可以使用两个栈，一个栈用来保存当前栈中的元素，其功能和一个正常的栈没有区别，这个栈记为stackData
 *          另一个栈用于保存每一步的最小值，这个栈记为stcjMin
 *
 *
 * @author qinxuewu
 * @version 1.00
 * @time  9/4/2019 上午 10:43
 * @email 870439570@qq.com
 */
public class GetMinStack01 {
    /**
     * 保存当前栈中的元素
     */
    Stack<Integer>  stackData=new Stack<>();

    /**
     * 用于保存每一步的最小值
     */
    Stack<Integer> stackMin=new Stack<>();


    /**
     *
     * 入栈
     *  先讲x压入stackData栈中，然后判断stackMin是否为空
     *  如果为空，则将x也压入stackMin
     *  如果不为空，则比较下x和stackMin的种元素哪一个较小
     *  如果stackMin元素较小则不做任何操作
     *  如果x较小或两者相等，则将x压入stackMin
     *
     * @param x
     */
    public void push(int x) {
        stackData.push(x);
        if(stackMin.isEmpty()){
            stackMin.push(x);
        }else{
            if(x<=stackMin.peek()){
                stackMin.push(x);
            }
        }
    }

    /**
     * 出栈
     * 先在stackData中弹出栈顶元素，记为value。然后比较当前stackMin的栈顶元素和value哪一个更小
     *  stackMin中存在的元素是从栈底到栈顶逐渐变小的,stackMin栈顶的元素既是stackMin栈最小的值，也就是当前stackData中最小的值
     *  所以不会出现value比stackMin的栈顶元素更小的情况
     *
     *  当value等于stackMin栈顶的元素时。stackMin弹出栈顶元素，否则返回value
     */
    public int pop() {
        if(stackData.isEmpty()){
            throw  new RuntimeException("栈为空");
        }
        Integer value=stackData.peek();
        Integer min=stackMin.peek();
        if(value.intValue()==min.intValue()){
                return stackMin.pop();
        }else{
                return  stackData.pop();
        }
    }

    public int top() {
        return  stackData.peek();
    }

    /**
     * 获取栈中的最小元素。
     * @return
     */
    public int getMin() {
        if(stackData.isEmpty()){
            throw  new RuntimeException("栈为空");
        }
        return  stackMin.peek();
    }

    public static void main(String[] args) {
        GetMinStack01  stack01=new GetMinStack01();
        stack01.push(5);
        stack01.push(2);
        stack01.push(3);

        System.out.println(stack01.getMin());
        System.out.println(stack01.top());
//        System.out.println(stack01.pop());
    }
}
