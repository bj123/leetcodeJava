package com.example;

/**
 * 整数反转
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 输入: 123
 * 输出: 321
 *
 *
 * 输入: -123
 * 输出: -321
 *
 * 输入: 120
 * 输出: 21
 *
 * 不能使用字符串强制转换
 * @author qinxuewu
 * @version 1.00
 * @time  3/4/2019 上午 10:39
 * @email 870439570@qq.com
 */
public class LettCode07 {

    public static void main(String[] args) {
        int a=123;

        System.out.println(reverseInteger(a));

    }

    /**
     * 思路：我们可以一次构建反转整数的一位数字。在这样做的时候，我们可以预先检查向原整数附加另一位数字是否会导致溢出。
     *
     * 不断模10取得最低位，再不断乘10相加得到最终的反转结果
     * @param x
     * @return
     */
    public  static int reverseInteger(int x) {
        int res = 0;  //存储结果
        while (x != 0) {
            int temp = res * 10 + x % 10;
            System.out.println("temo:"+temp);
            x = x / 10; //不断取前几位
            System.out.println("temp / 10 ====="+temp / 10 );
            System.out.println("res ====="+temp / 10 );
            if (temp / 10 != res) {
                res = 0;
                break;
            }
            res = temp;
        }
        return res;
    }

}
