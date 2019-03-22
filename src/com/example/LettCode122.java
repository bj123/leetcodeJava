package com.example;

/**
 * 买卖股票的最佳时机 II
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 * @author qinxuewu
 * @version 1.00
 * @time  22/3/2019 上午 10:08
 * @email 870439570@qq.com
 */
public class LettCode122 {

    // 如果第二个数字大于第一个数字，我们获得的总和将是最大利润
    public static int maxProfit(int[] prices) {
        int max=0;
        for (int i = 1; i <prices.length ; i++) {
            if(prices[i] >  prices[i-1]){
                max+=prices[i]-prices[i-1];
            }
        }

        return  max;
    }

    public static void main(String[] args) {
        int [] prices={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
