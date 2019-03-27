package com.example;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 *
 * @author qinxuewu
 * @version 1.00
 * @time  27/3/2019 上午 10:45
 * @email 870439570@qq.com
 */
public class LettCode155 {

    private int[] items; //数组实现栈操作
    private int count; //栈中元素个数

    private int[] support_items; //辅助数组保存最小值
    private int support_count; //辅助栈中元素个数
    private int size = 800; //栈的大小


    public LettCode155() {
        this.items = new int[this.size];
        this.support_items = new int[this.size];
        this.count = 0;
    }

    public void push(int x) {
        // 栈满，直接返回
        if (count == size || support_count == size) return;

        if (support_count == 0 || support_items[support_count - 1] >= x){
            support_items[support_count] = x;
            ++support_count;
        }


        items[count] = x;
        ++count;
    }

    public void pop() {
        if (count == 0 || support_count == 0) return;
        if (items[count - 1] == support_items[support_count - 1])
            --support_count;

        --count;
    }

    public int top() {
        if (count == 0 || support_count == 0) return -1;

        return items[count - 1];
    }

    public int getMin() {
        if (support_count == 0) return -1;

        return support_items[support_count - 1];
    }
}
