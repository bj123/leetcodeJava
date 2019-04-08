package com.example;

import java.util.Arrays;

/**
 * 反转字符串
 *
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 *  输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * @author qinxuewu
 * @version 1.00
 * @time  8/4/2019 上午 11:15
 * @email 870439570@qq.com
 */
public class LettCode344 {

    public static void main(String[] args) {
        char[] ch = {'h','e','l','l','o'};
        reverseString(ch);

    }
    /**
     * 直接从两头往中间走，同时交换两边的字符
     * @param s
     */
    public static void reverseString(char[] s) {
        if(s == null || s.length <= 1) return;
        int len = s.length;
        int k=len/2;  //定义一个中间值 循环一次减去半
        for (int i = 0; i < k; i++) {
            char temp=s[i];
            s[i]=s[len-1-i];
            s[len-1-i]=temp;
        }
        System.out.println(Arrays.toString(s));
    }
}
