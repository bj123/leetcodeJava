package com.example;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *  167. 两数之和 II - 输入有序数组\
 *
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 *
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * @author qinxuewu
 * @version 1.00
 * @time  17/4/2019 下午 6:23
 * @email 870439570@qq.com
 */
public class LettCode167 {

    public static void main(String[] args) {
        int [] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.err.println(Arrays.toString(twoSum3(nums, target)));
    }

    /**
     * 保利破解法
     * @param numbers
     * @param target
     * @return
     */
    public  static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j <numbers.length ; j++) {
                if(numbers[i]+numbers[j]==target){
                    return new int[] {i+1,j+1};
                }
            }
        }
        return  null;
    }

    /**
     * map求法
     * @param numbers
     * @param target
     * @return
     */
    public  static int[] twoSum2(int[] numbers, int target) {
        Map<Integer,Integer> map=new HashMap<>(2);
        for (int i = 0; i <numbers.length ; i++) {
            int result=target-numbers[i];
            if(map.containsKey(result)){
                return  new int[]{map.get(result)+1,i+1};
            }
            map.put(numbers[i],i);
        }
        return  null;
    }


    /**
     * 双指针 解法  定义个头指针和尾指针
     * @param numbers
     * @param target
     * @return
     */
    public  static int[] twoSum3(int[] numbers, int target) {
        //初始化头指针和尾指针
        int l=0,r=numbers.length-1;
        int [] res={0,0};
        while (l<r){
            //如果等于 说明找到了下标
            if(numbers[l]+numbers[r]==target){
                res[0]=l+1;
                res[1]=r+1;
                break;
            }else if(numbers[l]+numbers[r] < target){
                //头尾指针对应的数据 相加 小于目标target  则头指针向前移动
                l++;
            }else{
                //否则大于  尾指针也向前移一步
                r--;
            }

        }
        return  res;
    }


}
