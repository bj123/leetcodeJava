package com.example;

/**
 * 乘积最大子序列
 *
 * 给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
 *
 * 输入: [2,3,-2,4]
 * 输出: 6
 * 解释: 子数组 [2,3] 有最大乘积 6。
 *
 *
 * 输入: [-2,0,-1]
 * 输出: 0
 * 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 *
 * @author qinxuewu
 * @version 1.00
 * @time  2/4/2019 下午 12:48
 * @email 870439570@qq.com
 */
public class LettCode152 {

    public static void main(String[] args) {

    }

    /**
     * 动态规划：
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {

        //状态定义
        //DP方程

        //用来存放正数最大值
        int[] a = new int[nums.length];
        a[0] = nums[0];

        //用来存放负数最小值
        int[] b = new int[nums.length];
        b[0] = nums[0];

        int result = a[0];


        for (int i = 1; i < nums.length; i++) {
            if (nums[i] >= 0) {
                a[i] = Math.max(nums[i], a[i - 1] * nums[i]);
                b[i] = Math.min(nums[i], b[i - 1] * nums[i]);
            } else {
                a[i] = Math.max(nums[i], b[i - 1] * nums[i]);
                b[i] = Math.min(nums[i], a[i - 1] * nums[i]);
            }
            result = Math.max(result, a[i]);
        }
        return result;
    }

    public int maxProduct2(int[] nums) {
        //一个保存最大的，一个保存最小的。
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for(int i=0; i<nums.length; i++){

            //如果数组的数是负数，那么会导致最大的变最小的，最小的变最大的。因此交换两个的值。
            if(nums[i] < 0){
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax*nums[i], nums[i]);
            imin = Math.min(imin*nums[i], nums[i]);
            max = Math.max(max, imax);
        }
        return max;
    }
}
