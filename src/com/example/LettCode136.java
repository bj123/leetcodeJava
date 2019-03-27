package com.example;

import java.util.*;

/**
 * 只出现一次的数字
 *
 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 *
 * 输入: [2,2,1]  输出: 1
 * 输入: [4,1,2,1,2]  输出: 4
 * @author qinxuewu
 * @version 1.00
 * @time  26/3/2019 上午 10:26
 * @email 870439570@qq.com
 */
public class LettCode136 {


    /**
     *   Java中的位运算符中有一个叫做异或的运算符，符号为（^）,其主要是对两个操作数进行位的异或运算，
     *   相同取0，相反取1。即两操作数相同时，互相抵消。
     *
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int a = 0;
        for(int i=0;i<nums.length;i++){
            a=a^nums[i];
        }
        System.out.println("不相同的那个数是："+a);
        return  a;
    }

    //异或是一种基于二进制的位运算，用符号XOR或者 ^ 表示，其运算法则是对运算符两侧数的每一个二进制位，同值取0，异值取1。
    public static void main(String[] args){
        int a=15;
        int b=2;
        //a=15的二进制是1111，b=2的二进制是0010，经过异或运算后，得到的二进制数为1101，转换为十进制就是13
        System.out.println("a^b="+(a^b));  // 输出  13

        //可以用来交换两个基本数据类型的变量的内容
        int f = 50;
        int g = 60;
        f = f^g;
        g = f^g;
        f = f^g;
        System.out.println(f+" "+g);  //60 50

    }


}
