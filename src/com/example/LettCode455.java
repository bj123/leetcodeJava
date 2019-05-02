package com.example;

import java.util.Arrays;

/**
 * 分发饼干  谈心算法
 *
 *  假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，
 *  这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j ，都有一个尺寸 sj 。
 *  如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。
 *  你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 *
 *  输入: [1,2,3], [1,1]
 *
 *  输出: 1
 *
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 *
 * @author qinxuewu
 * @version 1.00
 * @time  25/4/2019 上午 10:20
 * @email 870439570@qq.com
 */
public class LettCode455 {


    /**
     * 思路：
     *  首先排序两个数组 使其顺序存储
     *  优先满足需求因子最小的数。循环匹配。
     *  定义两个变量记录: child=代表满足了几个孩子，cookie代表已经使用了多少个饼干数组的数
     *  同时比遍历两个数组去匹配
     *
     * @param g
     * @param s
     * @return
     */
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child=0;
        int cookie=0;
        while (child<g.length && cookie<s.length){
            //当前孩子的需求 小与当前饼干的数  说明满足
            if(g[child]<=s[cookie]){
                ++child;
            }
            //不管满不满足孩子数组 都要累加饼干数组的计数器
            ++cookie;
        }

        return  child;
    }

    public static void main(String[] args) {
        int [] g={10,9,8,7};
        int [] s={5,6,7,8};
        System.out.println(findContentChildren(g,s));
    }
}
