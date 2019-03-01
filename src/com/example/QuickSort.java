package com.example;
import java.util.Arrays;

/**
 * 快速排序:
 * 
 * 快速排序在每一轮挑选一个基准元素，并让其他比它大的元素移动到数列一边， 比它小的元素移动到数列的另一边，从而把数列拆解成了两个部分。这种思路就叫做分治法
 * 
 * 
 * 基准元素如何选择？ 最简单的方式是选择第一个元素作为基准元素。 但是如果数列原本是逆序的 期望转成顺序。 比如 (8,7,6,5,4,3,2,1)
 * 就不会分割一半一半 每一轮只是确定了基准元素位置
 * 
 * 如何避免出？ 随机选一个元素作为基准元素 这样一来，即使在数列完全逆序的情况下，也可以有效地将数列分成两部分。
 * 当然，即使是随机选择基准元素，每一次也有极小的几率选到数列的最大值或最小值，同样会影响到分治的效果。 所以，快速排序的平均时间复杂度是
 * O（nlogn），最坏情况下的时间复杂度是 O（n^2）。
 * 
 * 
 * @author qinxuewu 2019年1月15日下午3:38:58
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[] { 4, 7, 6, 5, 3, 2, 8, 1 };
		quickSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

	public static void quickSort(int[] arr, int startIndex, int endIndex) {
		// 递归结束条件：startIndex大等于endIndex的时候
		if (startIndex >= endIndex) {
			return;
		}

		// 得到基准元素位置
		int pivotIndex = partition(arr, startIndex, endIndex);
		// 用分治法递归数列的两部
		quickSort(arr, startIndex, pivotIndex - 1);
		quickSort(arr, pivotIndex + 1, endIndex);

	}

	private static int partition(int[] arr, int startIndex, int endIndex) {
		// 取第一个位置的元素作为基准元素
		int pivot = arr[startIndex];
		int left = startIndex;
		int right = endIndex;
		// 坑的位置，初始等于pivot的位置
		int index = startIndex;
		// 大循环在左右指针重合或者交错时结束
		while (right >= left) {
			// right指针从右向左进行比较
			while (right >= left) {
				if (arr[right] < pivot) {
					arr[left] = arr[right];
					index = right;
					left++;
					break;
				}
				right--;
			}
			// left指针从左向右进行比较
			while (right >= left) {
				if (arr[left] > pivot) {
					arr[right] = arr[left];
					index = left;
					right--;
					break;
				}
				left++;
			}
		}
		arr[index] = pivot;
		return index;
	}

}
