package com.example;

import java.util.Arrays;

/**
 * 移除元素
 * 
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。

	不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
	
	元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

 * @author qinxuewu 2019年2月22日下午1:37:58
 *
 */
public class LettCode27 {

	/**
	 * 给定 nums = [3,2,2,3], val = 3,

		函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
		
		你不需要考虑数组中超出新长度后面的元素。
	 * @param args
	 */
	public static void main(String[] args) {
		int []nums={3,2,2,3};
		int val=3;
		System.out.println(removeElement(nums, val));
	}
	/**
	 * 
	 * @param nums
	 * @param val
	 * @return
	 */
	public static int removeElement(int[] nums, int val) {
		if(nums.length==0){
			return 0;
		}
		 int i = 0;
		 for (int j = 0; j < nums.length; j++) {
		    	 if (nums[j] != val) {
		             nums[i] = nums[j];
		             i++;
		         }
		  }
		 System.out.println(Arrays.toString(nums));
		return i;
	}
	
	public int removeElement2(int[] nums, int val) {
	    int i = 0;
	    int n = nums.length;
	    while (i < n) {
	    	//当我们遇到 nums[i] = val 时，我们可以将当前元素与最后一个元素进行交换，并释放最后一个元素
	    	//这实际上使数组的大小减少了 1
	        if (nums[i] == val) {
	            nums[i] = nums[n - 1];
	            n--;
	        } else {
	            i++;
	        }
	    }
	    return n;
	}
}
