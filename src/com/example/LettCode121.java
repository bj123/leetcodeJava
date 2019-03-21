package com.example;

/**
 * 买卖股票的最佳时机
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 *
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 *
 * 注意你不能在买入股票前卖出股票。
 *
 *
 * @author qinxuewu
 * @version 1.00
 * @time  21/3/2019 下午 5:57
 * @email 870439570@qq.com
 */
public class LettCode121 {


    /**
     * 解决思路： 需要找出给定数组中两个数字之间的最大差值（即，最大利润）。此外，第二个数字（卖出价格）必须大于第一个数字（买入价格）。
     *
     * 暴力法,两个循环遍历，一前一后
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        //最大差值
        int maxProfit=0;
        for (int i = 0; i <prices.length-1 ; i++) {
            for (int j = i+1; j <prices.length ; j++) {
                int temp=prices[j]-prices[i];
                if(temp>maxProfit){
                    maxProfit=temp;
                    System.out.println(prices[i]+","+prices[j]+"="+temp);

                }
            }
        }
        return  maxProfit;
    }

    /**
     * 方法二：一次遍历
     * @param prices
     * @return
     */
    public int maxProfit2(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }
    public static void main(String[] args) {
        int [] prices={7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}
