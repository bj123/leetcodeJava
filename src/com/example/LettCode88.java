package com.example;

import java.util.Arrays;

/**
 * 合并两个有序数组
 * 
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存
 * nums2 中的元素。
 * 
 * 
 * 输入: nums1 = [1,2,3,0,0,0], m = 3 nums2 = [2,5,6], n = 3
 * 
 * 输出: [1,2,2,3,5,6]
 * 
 * @author qinxuewu 2019年3月8日上午9:51:18
 *
 */
public class LettCode88 {

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 0, 0, 0 };
		int m = 3;
		int[] nums2 = { 2, 5, 6 };
		int n = 3;
		merge2(nums1, m, nums2, n);
	}

	/**
	 * 解法1：先合并 在用冒泡排序 效率低
	 * 
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int size = m + n - 1;
		// 合并，nums2补到nums1后面
		for (int i = 0; i < n; i++) {
			nums1[i + m] = nums2[i];
		}
		System.out.println(Arrays.toString(nums1));
		// 冒泡排序
		for (int i = 0; i < size; i++) {
			boolean falg = false;
			for (int j = 0; j < size - i; j++) {
				// 大于就交互位置
				if (nums1[j] > nums1[j + 1]) {
					int temp = nums1[j];
					nums1[j] = nums1[j + 1];
					nums1[j + 1] = temp;
					falg = true;
				}
			}
			if (!falg)
				break;
		}
		System.out.println(Arrays.toString(nums1));
	}

	/**
	 * 
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	  public static void merge2(int[] nums1, int m, int[] nums2, int n) {
	        for (int i = nums1.length - 1; i >= 0; i--) {
	        	//如果m为0 zhji
	            if (m == 0) {
	                nums1[i] = nums2[--n];
	            } else if (n == 0) {
	                break;
	            } else if (nums2[n - 1] > nums1[m - 1]) {
	                nums1[i] = nums2[--n];
	            } else {
	                nums1[i] = nums1[--m];
	            }
	        }
	        System.out.println(Arrays.toString(nums1));
	    }
}
