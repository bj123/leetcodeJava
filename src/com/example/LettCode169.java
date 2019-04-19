package com.example;

/**
 * 169. 求众数
 *
 *
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于  n/2 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 *
 * @author qinxuewu
 * @version 1.00
 * @time  19/4/2019 上午 10:07
 * @email 870439570@qq.com
 */
public class LettCode169 {


    public static void main(String[] args) {
        int [] nums={2,2,1,1,1,2,2};
        LettCode169 code=new LettCode169();
        int count=code.majorityElement(nums);
        System.out.println(count);
    }

    /**
     * 从第一个数开始count=1，遇到相同的就加1，遇到不同的就减1，减到0就重新换个数开始计数，总能找到最多的那个
     * @param nums
     * @return
     */

    public int majorityElement(int[] nums) {
        int  count=1;
        int maj=nums[0];
        for (int i =1; i <nums.length ; i++) {
                if(maj==nums[i]){
                    count++;
                }else{
                    count--;
                    if(count==0){
                        maj=nums[i+1];
                    }
                }
        }
        return maj;
    }

}
